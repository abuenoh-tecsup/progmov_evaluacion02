package com.bueno.alvaro.laboratoriocalificado02

fun main() {
    val agenda = Agenda()

    val contacto1 = Contacto(
        "Alvaro Bueno",
        "123456789",
        "alvaro.bueno@tecsup.edu.pe")
    val contacto2 = Contacto(
        "Eduardo Bullon",
        "987654321",
        "eduardo.bullon@tecsup.edu.pe")
    val contacto3 = Contacto(
        "Sonaly Sifuentes",
        "111111111",
        "sonaly.sifuentes@tecsup.edu.pe")

    agenda.agregarContacto(contacto1)
    agenda.agregarContacto(contacto2)
    agenda.agregarContacto(contacto3)

    println()
    agenda.listarContactos()

    println()
    agenda.buscarContactoPorNombre("Eduardo Bullon")
    agenda.buscarContactoPorNombre("Juan Rodriguez")
}
