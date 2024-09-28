package com.example.contact.room

import androidx.lifecycle.LiveData
import androidx.room.*

interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact): Long

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("DELETE FROM contact_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM contact_table")
    fun getAllContact(): LiveData<List<Contact>>

}