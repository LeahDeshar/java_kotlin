package com.example.crud;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnFetch, btnUpdate, btnDelete;

    EditText edName, edEmail, edPassword, edId;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAdd = findViewById(R.id.submit);
        btnFetch = findViewById(R.id.fetch_btn);

        edName = findViewById(R.id.name);
        edEmail = findViewById(R.id.email);
        edPassword = findViewById(R.id.password);
database =new Database(MainActivity.this);

        btnAdd.setOnClickListener(v -> {
           if(edEmail.length() > 1 && edName.length() > 1 && edPassword.length() > 1){
               database.insertUser(edName.getText().toString(), edEmail.getText().toString(), edPassword.getText().toString());
           }
        });

        btnFetch.setOnClickListener(v -> {
           startActivity(new Intent(MainActivity.this, FetchDataActivity.class));
        });


    }
}