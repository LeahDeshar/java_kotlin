package com.example.mvvm;

import android.os.Bundle;
import android.util.Log;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.databinding.ActivityNoteListItemBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private NoteDatabase noteDatabase;
    private ArrayList<Note> notes = new ArrayList<>();

    private MyAdapter noteAdapter;


    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        clickHandler = new MainActivityClickHandler(this);
        mainBinding.setClickHandler(clickHandler);

        RecyclerView recyclerView = mainBinding.recyclerView;
//        set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

//        adapter

        noteDatabase = NoteDatabase.getInstance(this);

        NoteViewModel noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

//        Inserting a new Note
//        noteViewModel.insert(new Note("Title 1", "Description 1"));
//        noteViewModel.insert(new Note("Title 2", "Description 2"));
//        noteViewModel.insert(new Note("Title 3", "Description 3"));
//        noteViewModel.insert(new Note("Title 4", "Description 4"));
//        noteViewModel.insert(new Note("Title 5", "Description 5"));



        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> newNotes) {
                notes.clear();

                // Add all new notes to the list
                notes.addAll(newNotes);

                // Notify the adapter
                noteAdapter.notifyDataSetChanged();
//                loop
//                for (Note note : notes) {
//                    Log.v("TAGY", note.getTitle());
//                    notes.add(note);
//                }
//                noteAdapter.notifyDataSetChanged();
//                noteAdapter.setNotesList((ArrayList<Note>) notes);
            }
        });
        noteAdapter = new MyAdapter(notes);

        recyclerView.setAdapter(noteAdapter);
    }
}