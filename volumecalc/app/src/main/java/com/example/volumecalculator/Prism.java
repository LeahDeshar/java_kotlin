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

public class Prism extends AppCompatActivity {

    EditText baseArea,height;
    TextView title,result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText prismBaseArea = findViewById(R.id.baseArea);
        EditText prismHeight = findViewById(R.id.height);
        TextView result = findViewById(R.id.result);
        Button btn = findViewById(R.id.btn1);

        btn.setOnClickListener(v -> {
            double baseArea = Double.parseDouble(prismBaseArea.getText().toString());
            double height = Double.parseDouble(prismHeight.getText().toString());
            double volume = baseArea * height;
            result.setText("Volume of Prism is: "+ Math.round(volume));
        });
    }
}