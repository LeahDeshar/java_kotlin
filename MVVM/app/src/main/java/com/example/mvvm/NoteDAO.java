package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    // Add a method to get all notes
    @Query("SELECT * FROM note")
    LiveData<List<Note>> getAllNotes();


    // Add a method to get a note by id
    @Query("SELECT * FROM note WHERE id = :id")
    LiveData<Note> getNoteById(int id);


    // Add a method to update a note
    @Query("UPDATE note SET title = :title, content = :content WHERE id = :id")
    void updateNoteById(int id, String title, String content);

    // Add a method to delete a note by id
    @Query("DELETE FROM note WHERE id = :id")
    void deleteNoteById(int id);

}
