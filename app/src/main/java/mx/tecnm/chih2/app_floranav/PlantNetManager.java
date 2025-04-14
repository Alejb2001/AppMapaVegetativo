package mx.tecnm.chih2.app_floranav;

import android.util.Log;

import java.io.File;
import java.util.Collections;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlantNetManager {
    private static final String API_KEY = "2b109zy4PxGy3stp5Px1QRO";
    private static final String BASE_URL = "https://my-api.plantnet.org/";

    public void identifyPlant(File imageFile, String organType) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlantNetService service = retrofit.create(PlantNetService.class);

        MultipartBody.Part imagePart = prepareImagePart(imageFile);
        List<MultipartBody.Part> parts = Collections.singletonList(imagePart);
        List<String> organs = Collections.singletonList(organType);

        Call<PlantIdentificationResponse> call = service.identifyPlant(API_KEY, parts, organs);
        call.enqueue(new Callback<PlantIdentificationResponse>() {
            @Override
            public void onResponse(Call<PlantIdentificationResponse> call, Response<PlantIdentificationResponse> response) {
                if (response.isSuccessful()) {
                    PlantIdentificationResponse body = response.body();
                    if (body != null && !body.getResults().isEmpty()) {
                        PlantIdentificationResponse.Result topResult = body.getResults().get(0);
                        String plantName = topResult.getSpecies().getScientificName();
                        savePlantToFirestore(plantName);
                    }
                }
            }

            @Override
            public void onFailure(Call<PlantIdentificationResponse> call, Throwable t) {
                Log.e("PlantNet", "Error en la API: " + t.getMessage());
            }
        });
    }

    private MultipartBody.Part prepareImagePart(File file) {
        return MultipartBody.Part.createFormData(
                "images",
                file.getName(),
                okhttp3.RequestBody.create(okhttp3.MediaType.parse("image/*"), file)
        );
    }

    private void savePlantToFirestore(String plantName) {
        // Implementar lógica de guardado en Firestore con ubicación
    }
}
