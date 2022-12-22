package com.example.databasefun

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(UserData::class)], version = 1)
abstract class UserDataDatabase: RoomDatabase() {

    abstract fun userDataDao(): UserDataDao

    companion object {
        private var INSTANCE: UserDataDatabase? = null

        fun getInstance(context: Context): UserDataDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataDatabase::class.java,
                        "user_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}