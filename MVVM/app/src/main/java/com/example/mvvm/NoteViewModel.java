package com.example.mvvm;

import android.app.Application;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
//import androidx.lifecycle.AndroidViewModel;


public class NoteViewModel extends ViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(Application application) {
        this.noteRepository = new NoteRepository(application);
    }

//    public NoteViewModel(Application application) {
//        super(application);
//        this.noteRepository = new NoteRepository(application);
//    }

      public LiveData<List<Note>> getAllNotes() {
        allNotes = noteRepository.getAllNotes();
        return allNotes;
      }

        public void insert(Note note) {
            noteRepository.insertNote(note);
        }

        public void delete(Note note) {
            noteRepository.deleteAllNote(note);
        }

        public void deleteNoteById(int id) {
            noteRepository.deleteNoteById(id);
        }

        public void updateNoteById(int id, String title, String content) {
            noteRepository.updateNoteById(id, title, content);
        }

        public LiveData<Note> getNoteById(int id) {
            return noteRepository.getNoteById(id);
        }

}
