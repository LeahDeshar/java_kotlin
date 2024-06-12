package com.example.ems.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {EmployeeEntity.class}, version = 1)
public abstract class EMSDatabase extends RoomDatabase{
    public abstract EmployeeDAO getEmployeeDAO();

    private static volatile EMSDatabase INSTANCE;

    public static EMSDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (EMSDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EMSDatabase.class, "employee")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
