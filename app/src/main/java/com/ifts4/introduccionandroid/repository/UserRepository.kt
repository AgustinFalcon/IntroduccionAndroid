package com.ifts4.introduccionandroid.repository

import androidx.lifecycle.LiveData
import com.ifts4.introduccionandroid.data.AppDatabase
import com.ifts4.introduccionandroid.data.model.User

class UserRepository {

    private val userDao = AppDatabase.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun insertUser(user: User) {
        userDao.insert(user = user)
    }

    suspend fun updateUser(user: User) {
        userDao.update(user = user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user = user)
    }

    suspend fun deleteAll() {
        userDao.deleteAll()
    }

}