package mx.tecnm.chih2.app_floranav;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvPlantName = findViewById(R.id.tvPlantName);
        TextView tvCharacteristics = findViewById(R.id.tvCharacteristics);

        // Obtener datos del Intent
        String plantName = getIntent().getStringExtra("PLANT_NAME");
        String characteristics = getIntent().getStringExtra("CHARACTERISTICS");

        // Mostrar datos
        tvPlantName.setText(plantName);
        tvCharacteristics.setText(characteristics);
    }
}