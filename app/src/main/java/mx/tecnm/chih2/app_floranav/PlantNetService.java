package mx.tecnm.chih2.app_floranav;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface PlantNetService {
    @Multipart
    @POST("v2/identify")
    Call<PlantIdentificationResponse> identifyPlant(
            @Query("api-key") String apiKey,
            @Part List<MultipartBody.Part> images,
            @Part("organs") List<String> organs
    );
}
