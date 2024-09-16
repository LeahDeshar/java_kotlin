package com.example.luckynumber;

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

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTxt,luckyNumber;
    Button sharebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        welcomeTxt = findViewById(R.id.textview2);
        luckyNumber = findViewById(R.id.luckytext);
        sharebtn = findViewById(R.id.sharebtn);

//        Receiving the data from the main activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

//        generating random number
        int rd_num = generateRandomNumber();
        luckyNumber.setText("" + rd_num);

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,rd_num);
            }
        });

    }

    public int generateRandomNumber(){
        Random rd = new Random();
        int upper = 1000;
        int res = rd.nextInt(upper);
        return res;
    }

    public void shareData(String username,int rdnum){
//        implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: " + rdnum);

        startActivity(Intent.createChooser(i,"Choose a Platform"));

    }
}