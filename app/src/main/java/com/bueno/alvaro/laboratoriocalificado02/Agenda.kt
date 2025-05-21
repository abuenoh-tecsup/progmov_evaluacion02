package com.bueno.alvaro.laboratoriocalificado02

class Agenda {
    private val listaContactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        listaContactos.add(contacto)
        println("Se ha agregado el contacto: ${contacto.nombre}")
    }

    fun listarContactos() {
        if (listaContactos.isEmpty()) {
            println("No existen contactos en la agenda.")
        } else {
            println("Contactos:")
            listaContactos.forEach { contacto: Contacto ->
                println("- Nombre: ${contacto.nombre}, Teléfono ${contacto.telefono}, Email: ${contacto.email}")
            }
        }
    }

    fun buscarContactoPorNombre(nombre : String) {
        var encontrado = false
        for (contacto in listaContactos) {
            if (contacto.nombre.contains(nombre, ignoreCase = true)) {
                println("Contacto encontrado")
                println("- Nombre: ${contacto.nombre}, Teléfono ${contacto.telefono}, Email: ${contacto.email}")
                encontrado = true
            }
        }
        if (!encontrado) {
            println("- No se encontró ningún contacto con el nombre: $nombre")
        }
    }

}