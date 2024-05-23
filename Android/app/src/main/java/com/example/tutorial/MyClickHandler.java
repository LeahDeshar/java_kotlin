package com.example.tutorial;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyClickHandler {
    Context context;

    public MyClickHandler(Context context) {
        this.context = context;
    }

    public void onButtonClick1(View view) {
        Toast.makeText(context, "First Button clicked!", Toast.LENGTH_SHORT).show();

    }

}
