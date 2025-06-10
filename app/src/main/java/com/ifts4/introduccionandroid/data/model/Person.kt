package com.ifts4.introduccionandroid.data.model

import com.ifts4.introduccionandroid.data.model.Colors

data class Person(
    val name: String,
    val lastName: String,
    val age: Int,
    val color: Colors
): java.io.Serializable