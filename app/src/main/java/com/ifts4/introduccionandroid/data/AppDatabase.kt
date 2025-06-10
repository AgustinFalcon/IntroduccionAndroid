package com.ifts4.introduccionandroid.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ifts4.introduccionandroid.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}