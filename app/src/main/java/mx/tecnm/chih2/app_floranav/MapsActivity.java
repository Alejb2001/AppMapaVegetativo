package mx.tecnm.chih2.app_floranav;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        loadPlantsFromFirestore();
    }

    private void loadPlantsFromFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("plants")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Plant plant = document.toObject(Plant.class);
                            LatLng location = new LatLng(plant.getLatitude(), plant.getLongitude());
                            mMap.addMarker(new MarkerOptions()
                                    .position(location)
                                    .title(plant.getName())
                                    .snippet(plant.getCharacteristics()));
                        }
                    }
                });
    }
}