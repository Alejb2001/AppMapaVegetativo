package mx.tecnm.chih2.app_floranav;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenCamera = findViewById(R.id.btnOpenCamera);
        Button btnViewMap = findViewById(R.id.btnViewMap);

        btnOpenCamera.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CameraActivity.class)));

        btnViewMap.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, MapsActivity.class)));
    }
}
