package com.example.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentActivity extends AppCompatActivity {
TextView fname,lname,email;
EditText etfname,etlname,etemail;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etfname = findViewById(R.id.editTextFName);
        etlname = findViewById(R.id.editTextLName);
        etemail = findViewById(R.id.editTextEmail);
        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getfname = etfname.getText().toString();
                String getlname = etlname.getText().toString();
                String getemail = etemail.getText().toString();

                fname.setText(getfname);
                lname.setText(getlname);
                email.setText(getemail);






//                Intent intent = new Intent(IntentActivity.this,IntentActivityII.class);
//                intent.putExtra("fname",fname);
//                intent.putExtra("lname",lname);
//                intent.putExtra("email",email);
//                startActivity(intent);
            }
        });


    }
}