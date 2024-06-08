package com.example.mvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
//    linking DAO and DB
    public abstract NoteDAO noteDAO();

//    Create the instance of db using Singleton pattern
    private static NoteDatabase instance;

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
