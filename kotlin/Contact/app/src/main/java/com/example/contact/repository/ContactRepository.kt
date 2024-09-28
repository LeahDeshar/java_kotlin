package com.example.contact.repository

import com.example.contact.room.Contact
import com.example.contact.room.ContactDAO

class ContactRepository (private val contactDAO : ContactDAO){

    val contacts = contactDAO.getAllContact()

    suspend fun insertContact(contact: Contact) : Long{
       return contactDAO.insertContact(contact)
    }

    suspend fun updateContact(contact: Contact){
        return contactDAO.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact){
       return contactDAO.deleteContact(contact)
    }

    suspend fun deleteAll(){
        return contactDAO.deleteAll()
    }


}