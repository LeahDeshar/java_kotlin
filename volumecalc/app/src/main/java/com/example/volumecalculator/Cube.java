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

public class Cube extends AppCompatActivity {
    EditText cubeSide;
    TextView title,result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cubeSide = findViewById(R.id.e_cube);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(v -> {
            double side = Double.parseDouble(cubeSide.getText().toString());
            double volume = Math.pow(side,3);
            result.setText("Volume= "+ Math.round(volume));
        });

    }
}