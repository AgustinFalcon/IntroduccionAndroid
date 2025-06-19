package com.ifts4.introduccionandroid.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ifts4.introduccionandroid.DesaMobileApp
import com.ifts4.introduccionandroid.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        // Singleton
        fun getDatabase(): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    DesaMobileApp.instance.applicationContext,
                    AppDatabase::class.java,
                    "desa_mobile_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}