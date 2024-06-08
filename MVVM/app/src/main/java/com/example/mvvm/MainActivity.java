package com.example.mvvm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private TextView textView;
    private EditText editTextTitle, editTextContent;

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


        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        textView = findViewById(R.id.textView);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        Button addButton = findViewById(R.id.addButton);
        Button updateButton = findViewById(R.id.updateButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        noteViewModel.getNoteList().observe(this, notes -> {
            updateUI(notes);
        });

        addButton.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString().trim();
            String content = editTextContent.getText().toString().trim();
            if (!title.isEmpty() && !content.isEmpty()) {
                int nextId = noteViewModel.getNoteList().getValue().size() + 1;
                noteViewModel.addOrUpdateNote(new Note(nextId, title, content));
                editTextTitle.setText("");
                editTextContent.setText("");
            }
        });

        updateButton.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString().trim();
            String content = editTextContent.getText().toString().trim();
            if (!title.isEmpty() && !content.isEmpty()) {
                Note selectedNote = noteViewModel.getNoteList().getValue().get(0); // Assuming first note for simplicity
                noteViewModel.addOrUpdateNote(new Note(selectedNote.getId(), title, content));
            }
        });

        deleteButton.setOnClickListener(v -> {
            Note selectedNote = noteViewModel.getNoteList().getValue().get(0); // Assuming first note for simplicity
            noteViewModel.deleteNoteById(selectedNote.getId());
        });
    }

    private void updateUI(List<Note> notes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Note note : notes) {
            stringBuilder.append("ID: ").append(note.getId())
                    .append(", Title: ").append(note.getTitle())
                    .append(", Content: ").append(note.getContent())
                    .append("\n");
        }
        textView.setText(stringBuilder.toString());
    }

}