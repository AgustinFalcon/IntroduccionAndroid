package com.ifts4.introduccionandroid.ui.model

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val lastName: String,
    val age: Int
): Serializable
