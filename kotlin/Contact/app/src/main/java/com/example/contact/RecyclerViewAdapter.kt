package com.example.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.databinding.ListItemBinding
import com.example.contact.room.Contact

class RecyclerViewAdapter (private val contactsList:List<Contact>,private val clickListener: (Contact) -> Unit):RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactsList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    class ContactViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact, clickListener: (Contact) -> Unit) {
            binding.title.text = contact.contact_name
            binding.email.text = contact.contact_number
            binding.root.setOnClickListener {
                clickListener(contact)
            }
        }

    }
}