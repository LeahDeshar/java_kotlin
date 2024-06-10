package com.example.mvvm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AddNewNoteClickHandler {
    Note note;
    Context context;
    NoteViewModel noteViewModel;

    public AddNewNoteClickHandler(Note note, Context context, NoteViewModel noteViewModel) {
        this.note = note;
        this.context = context;
        this.noteViewModel = noteViewModel;
    }

    public void onSubmitBtnClicked(View view) {
        Log.d("AddNewNoteClickHandler", "Title: " + note.getTitle());
        Log.d("AddNewNoteClickHandler", "Content: " + note.getContent());
        if(note.getTitle() == null || note.getContent() == null) {
            Toast.makeText(context, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(context, MainActivity.class);
//            i.putExtra("Title", note.getTitle());
//            i.putExtra("Content", note.getContent());

            Note note1 = new Note(
                    note.getTitle(),
                    note.getContent()
            );
            noteViewModel.insert(note1);
            context.startActivity(i);
            Toast.makeText(context, "Note Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
