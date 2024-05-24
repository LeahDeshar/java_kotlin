package com.example.contactmanagerapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDAO {

    @Delete
    void deleteContact(Contacts contacts);

    @Insert
    void insert(Contacts contacts);


    @Query("SELECT * FROM contacts_table")
    List<Contacts> getAllContacts();


}
