package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application, Repository repository){
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){
         allContacts = repository.getAllContacts();
         return allContacts;
    }

    public void addContact(Contacts contacts){
        repository.addContact(contacts);
    }

    public void deleteContact(Contacts contacts){
        repository.deleteContact(contacts);
    }

}
