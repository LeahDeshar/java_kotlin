package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MyViewModel extends AndroidViewModel {
    private Repository repository;

    public MyViewModel(@NonNull Application application, Repository repository){
        super(application);
        repository = new Repository(application);
    }
}
