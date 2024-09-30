//package com.example.contact.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [Contact::class], version = 1)
//abstract class ContactDatabase: RoomDatabase() {
//
//
//    abstract val contactDAO(): ContactDAO
//
//
//            companion object {
//                @Volatile
//                private var INSTANCE: ContactDatabase? = null
//
//                fun getInstance(context: Context) : ContactDatabase {
//                    synchronized(this) {
//                        var instance = INSTANCE
//                        if (instance == null) {
//                            instance = Room.databaseBuilder(
//                                context.applicationContext,
//                                ContactDatabase::class.java,
//                                "contact_database"
//                            ).build()
//                        }
//                        INSTANCE = instance
//
//                        return instance
//                    }
//                }
//            }
//
//
//}

package com.example.contact.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract val contactDAO: ContactDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase {
            // Ensuring that the database creation is synchronized to prevent multiple threads from creating it
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact_database"
                    )
                        // Optional: use fallback to destructive migration if migrations are not yet handled
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance // Assign the instance to the INSTANCE variable
                }
                return instance
            }
        }
    }
}
