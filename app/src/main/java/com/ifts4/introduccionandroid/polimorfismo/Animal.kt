package com.ifts4.introduccionandroid.polimorfismo


// Clase base (superclase)
open class Animal(val nombre: String) {


    open fun doSound() {
        println("El animal $nombre hace un sonido.")
    }
}