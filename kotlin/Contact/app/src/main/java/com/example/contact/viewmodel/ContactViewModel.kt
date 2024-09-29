package com.example.contact.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contact.repository.ContactRepository
import com.example.contact.room.Contact
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ContactViewModel(private val repository: ContactRepository) :ViewModel(),Observable {


    val contacts = repository.contacts
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: Contact

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText =  MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun insert(contact : Contact) = viewModelScope.launch {
        repository.insertContact(contact)
    }

    fun delete(contact : Contact) = viewModelScope.launch {
        repository.deleteContact(contact)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }


    fun update(contact : Contact) = viewModelScope.launch {
        repository.updateContact(contact)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun saveOrUpdate(){
        if(isUpdateOrDelete){
            userToUpdateOrDelete.contact_name = inputName.value!!
            userToUpdateOrDelete.contact_number = inputEmail.value!!

            update(userToUpdateOrDelete)
        }else{
            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(Contact(0,name,email))

            inputName.value = null
            inputEmail.value = null
        }

    }

    fun clearAllOrDelete(){
        if(isUpdateOrDelete){
            delete(userToUpdateOrDelete)
        }else{
            clearAll()
        }
    }


    fun initUpdateAndDelete(contact: Contact){
        inputName.value = contact.contact_name
        inputEmail.value = contact.contact_number

        isUpdateOrDelete = true
        userToUpdateOrDelete = contact

        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }


}