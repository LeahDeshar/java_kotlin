package com.example.layout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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


        TextView resultTxt;
        EditText nameEt,phnEt;
        Button btn,detailBtn;
        CheckBox checkBox;


        btn = findViewById(R.id.button);
        detailBtn = findViewById(R.id.detailBtn);
        resultTxt = findViewById(R.id.result);
        checkBox = findViewById(R.id.checkBox);


        boolean isCheckedOpt = false;
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                isCheckedOpt = true;




            }else{
            }
        });



        nameEt = findViewById(R.id.editName);
        phnEt = findViewById(R.id.editPhoneNumber);

        btn.setOnClickListener(v -> {
            String name = nameEt.getText().toString();
            String phn = phnEt.getText().toString();

            resultTxt.setText("Name: "+name+"\nPhone Number: "+phn);
        });

 detailBtn.setOnClickListener(v ->{
     Intent i = new Intent(MainActivity.this,MainActivity2.class);
     i.putExtra("name",nameEt.getText().toString());
        i.putExtra("phn",phnEt.getText().toString());
        startActivity(i);
 });

    }
}