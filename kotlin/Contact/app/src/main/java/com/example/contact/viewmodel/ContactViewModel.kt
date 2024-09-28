package com.example.contact.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.contact.repository.ContactRepository
import com.example.contact.room.Contact

class ContactViewModel(private val repository: ContactRepository) :ViewModel(),Observable {


    val contacts = repository.contacts
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: Contact

}