package com.example.mvvm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.databinding.ActivityAddNewNoteBinding;

public class AddNewNoteActivity extends AppCompatActivity {

    private ActivityAddNewNoteBinding addNewNoteBinding;
    private AddNewNoteClickHandler clickHandler;
    private Note notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        notes = new Note(
                getIntent().getStringExtra("title"),
                getIntent().getStringExtra("content")
        );
        addNewNoteBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_note);


        NoteViewModel noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        clickHandler = new AddNewNoteClickHandler(notes,this,noteViewModel);
        addNewNoteBinding.setClickHandler(clickHandler);
    }
}