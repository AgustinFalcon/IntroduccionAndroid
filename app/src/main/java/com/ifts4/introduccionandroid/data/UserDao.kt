package com.ifts4.introduccionandroid.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ifts4.introduccionandroid.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User) //insert



}