package com.ifts4.introduccionandroid.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ifts4.introduccionandroid.data.model.User


@Dao
interface UserDao {

    @Query("SELECT * FROM users ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>> //getAll

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User) //insert

    @Update
    suspend fun update(user: User) //update

    @Delete
    abstract fun deleteUser(user: User) //delete un usuario

    @Query("DELETE FROM user_table")
    suspend fun deleteAll() //delete todos

}