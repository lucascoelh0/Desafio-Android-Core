package com.example.desafioandroidcore.ui.domain

class Restaurante(
    val nome: String,
    val endereco: String,
    val horarioQueFecha: String,
    val pratoPrincipal: String,
    val img: Int,
    val imgPratoPrincipal: Int
) {
    override fun toString(): String {
        return "Restaurant(name='$nome', address='$endereco', openUntil='$horarioQueFecha', mainCourse='$pratoPrincipal')"
    }
}