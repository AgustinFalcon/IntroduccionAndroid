package com.ifts4.introduccionandroid.interfaces


fun main() {

    val claseA = ClaseA()
    claseA.iniciarComunicacion()

}

class ClaseA : Comunicador {

    override fun enviarMensaje(mensaje: String) {
        println("ClaseA recibió: $mensaje")
    }

    fun iniciarComunicacion() {
        println("Inicia comunicador")
        val claseB = ClaseB(this)
        claseB.realizarAccion()
    }

}

class ClaseB(private val comunicador: Comunicador) {

    fun realizarAccion() {
        println("Paso por realizar accion")
        val mensaje = "¡Esta accion fue enviada desde la ClaseB!"
        comunicador.enviarMensaje(mensaje)
    }
}
