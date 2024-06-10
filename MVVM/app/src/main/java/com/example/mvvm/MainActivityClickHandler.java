package com.example.mvvm;


import com.example.mvvm.AddNewNoteActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;



public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }


    public void onFabClicked(View view) {
        Intent i =  new Intent(view.getContext(), AddNewNoteActivity.class);
        context.startActivity(i);
    }
}
