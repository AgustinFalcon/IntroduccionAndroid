package com.ifts4.introduccionandroid.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre")
    val name: String,
    @ColumnInfo(name = "apellido")
    val lastName: String,
    @ColumnInfo(name = "edad")
    val age: Int
): Serializable
