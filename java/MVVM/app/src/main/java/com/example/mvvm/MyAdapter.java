package com.example.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.databinding.ActivityNoteListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NoteViewHolder>{

    private ArrayList<Note> notesList ;

    public MyAdapter(ArrayList<Note> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ActivityNoteListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.activity_note_list_item,parent,false);

        return new NoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.NoteViewHolder holder, int position) {
        Note currentNote = notesList.get(position);
        holder.binding.setNote(currentNote);


    }

    @Override
    public int getItemCount() {
        if(notesList!=null) {
            return notesList.size();
        }
        else {
            return 0;
        }
    }


    public void setNotesList(ArrayList<Note> notesList) {
        this.notesList = notesList;
        notifyDataSetChanged();
    }
    public class NoteViewHolder extends RecyclerView.ViewHolder {
        private ActivityNoteListItemBinding binding;

        public NoteViewHolder(@NonNull ActivityNoteListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
