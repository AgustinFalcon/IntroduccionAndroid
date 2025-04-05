package com.ifts4.introduccionandroid.polimorfismo


class Dog(nombre: String): Animal(nombre = nombre) {

    override fun doSound() {
        println("El perro $nombre hace: ¡Guau!")
    }

}