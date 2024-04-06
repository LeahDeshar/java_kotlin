package com.example.volumecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sphere extends AppCompatActivity {
EditText sphereRadius;
TextView title,result;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sphereRadius = findViewById(R.id.e_sphere);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(v -> {
            double radius = Double.parseDouble(sphereRadius.getText().toString());
            double volume = (4.0/3.0) * Math.PI * Math.pow(radius,3);
            result.setText("Volume= "+ Math.round(volume));
        });

    }
}