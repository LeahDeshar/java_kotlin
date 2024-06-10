package com.example.mvvm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewNoteClickHandler {
    Note note;
    Context context;

    public void onSubmitBtnClicked(View view) {

        if(note.getTitle() == null || note.getContent() == null) {
            Toast.makeText(context, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("Title", note.getTitle());
            i.putExtra("Content", note.getContent());
            context.startActivity(i);
            Toast.makeText(context, "Note Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
