package com.example.desafioandroidcore.ui.restaurante

import java.io.Serializable

class Restaurante(
    val nome: String,
    val endereco: String,
    val horarioQueFecha: String,
    val pratoPrincipal: String,
    val img: Int,
    val imgPratoPrincipal: Int
) : Serializable {
    override fun toString(): String {
        return "Restaurant(name='$nome', address='$endereco', openUntil='$horarioQueFecha', mainCourse='$pratoPrincipal')"
    }
}