package com.example.contact

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contact.databinding.ActivityMainBinding
import com.example.contact.repository.ContactRepository
import com.example.contact.room.Contact
import com.example.contact.room.ContactDatabase
import com.example.contact.viewmodel.ContactViewModel
import com.example.contact.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactViewModel : ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = ContactDatabase.getInstance(applicationContext).contactDAO
        val repository = ContactRepository(dao)
        val factory = ViewModelFactory(repository)

       contactViewModel = ViewModelProvider(this,factory).get(ContactViewModel::class.java)
        binding.contactViewModel = contactViewModel

        binding.lifecycleOwner = this

        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayUserList()
    }

    private fun displayUserList() {
        contactViewModel.contacts.observe(this, {
            binding.recyclerView.adapter = RecyclerViewAdapter(it,
                {selectedItem: Contact -> listItemClicked(selectedItem)})
        })
    }


    private fun listItemClicked(contact: Contact) {
        Toast.makeText(this,"Selected name is ${contact.contact_name}",Toast.LENGTH_LONG).show( )

        contactViewModel.initUpdateAndDelete(contact)
    }
}