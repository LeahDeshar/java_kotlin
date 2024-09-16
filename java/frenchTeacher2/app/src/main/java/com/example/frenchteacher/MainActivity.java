package com.example.frenchteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button blackBtn,yellowbtn,redBtn,greenBtn,purpleBtn;
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
        blackBtn = findViewById(R.id.blackBtn);
        yellowbtn = findViewById(R.id.yellowBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        redBtn = findViewById(R.id.redBtn);
        greenBtn = findViewById(R.id.greenBtn);



        redBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        yellowbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int clickedId = view.getId();
        if(clickedId == R.id.redBtn)
        {
            playSound(R.raw.red);
        }else if(clickedId == R.id.yellowBtn)
        {
            playSound(R.raw.yellow);
        }else if(clickedId == R.id.purpleBtn)
        {
            playSound(R.raw.purple);
        }else if(clickedId == R.id.blackBtn)
        {
            playSound(R.raw.black);
        }else if(clickedId == R.id.greenBtn)
        {
            playSound(R.raw.green);
        }

    }

    public void playSound(int id)
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,id);
        mediaPlayer.start();
    }
}