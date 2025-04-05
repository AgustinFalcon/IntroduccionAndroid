package com.ifts4.introduccionandroid.polimorfismo


fun main() {

    val dog: Animal = Dog("Firulais")
    val cat: Animal = Cat("Michifus")


    dog.doSound() // Llama al doSound() de la class Perro
    cat.doSound() // Llama al doSound() de la class Gato

}