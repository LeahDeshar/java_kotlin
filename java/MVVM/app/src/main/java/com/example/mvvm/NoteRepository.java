package com.example.mvvm;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private final NoteDAO noteDao;
    ExecutorService executor;
    Handler handler;
    public NoteRepository( Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
//        this.noteDao = noteDao;
        this.noteDao = noteDatabase.getNoteDAO();

         executor = Executors.newSingleThreadExecutor();
         handler = new Handler(Looper.getMainLooper());
    }

    public void insertNote(Note note) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(note);
            }
        });
    }

    public void deleteNoteById(int id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.deleteNoteById(id);
            }
        });

    }

    public void deleteAllNote(Note note){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.delete(note);
            }
        });

    }

    public void updateNoteById(int id, String title, String content) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.updateNoteById(id, title, content);
            }
        });

    }

    public LiveData<Note> getNoteById(int id) {

        return noteDao.getNoteById(id);
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteDao.getAllNotes();
    }




}
