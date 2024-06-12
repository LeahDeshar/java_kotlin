package com.example.ems.Model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class EMSDatabase extends RoomDatabase{
    public abstract EmployeeDAO employeeDAO();

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
