package com.example.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class IntentActivityII extends AppCompatActivity {
    TextView fname,lname,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_ii);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);

        Intent intent = getIntent();
        String getfname = intent.getStringExtra("firstName");
        String getlname = intent.getStringExtra("lastName");
        String getemail = intent.getStringExtra("email");

        fname.setText(getfname);
        lname.setText(getlname);
        email.setText(getemail);

        Button next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the next activity
                Intent intent = new Intent(IntentActivityII.this, IntentActivityII.class);
                // Pass data to the next activity using Intent extras
                intent.putExtra("firstName", etfname.getText().toString());
                intent.putExtra("lastName", etlname.getText().toString());
                intent.putExtra("email", etemail.getText().toString());
                // Start the next activity
                startActivity(intent);
            }
        });




    }
}