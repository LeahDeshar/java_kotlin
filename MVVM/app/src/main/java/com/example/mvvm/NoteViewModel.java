package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NoteViewModel extends ViewModel {
    private MutableLiveData<List<Note>> noteList;

    public LiveData<List<Note>> getNoteList() {
        if (noteList == null) {
            noteList = new MutableLiveData<>();
            loadNotes(); // Load initial notes
        }
        return noteList;
    }

    public void addOrUpdateNote(Note note) {
        List<Note> notes = noteList.getValue();
        if (notes == null) {
            notes = new ArrayList<>();
        }
        boolean found = false;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == note.getId()) {
                notes.set(i, note);
                found = true;
                break;
            }
        }
        if (!found) {
            notes.add(note);
        }
        noteList.setValue(notes);
    }

    public void deleteNoteById(int id) {
        List<Note> notes = noteList.getValue();
        if (notes != null) {
            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getId() == id) {
                    notes.remove(i);
                    break;
                }
            }
            noteList.setValue(notes);
        }
    }

    private void loadNotes() {
        // Hardcoded initial notes
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1, "Note 1", "Content 1"));
        notes.add(new Note(2, "Note 2", "Content 2"));
        notes.add(new Note(3, "Note 3", "Content 3"));
        noteList.setValue(notes);
    }
}
