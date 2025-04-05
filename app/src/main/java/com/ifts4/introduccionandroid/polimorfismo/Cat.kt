package com.ifts4.introduccionandroid.polimorfismo

class Cat(nombre: String): Animal(nombre = nombre) {

    override fun doSound() {
        println("El gato $nombre hace: ¡Miau!")
    }

}