package com.example.contact.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="contact_table")
data class Contact
(    @PrimaryKey(autoGenerate = true)
    val contact_id: Int,
    val contact_name: String,
    val contact_number: String
)
