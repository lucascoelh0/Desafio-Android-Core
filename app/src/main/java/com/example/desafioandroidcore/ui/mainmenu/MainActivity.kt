package com.example.desafioandroidcore.ui.mainmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.ui.restaurante.Restaurante
import com.example.desafioandroidcore.ui.restaurante.RestaurantesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RestaurantesAdapter.OnClickRestauranteListener {

    var listaRestaurantes = getAllRestaurantes()
    var adapter = RestaurantesAdapter(listaRestaurantes, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRestaurantes.adapter = adapter
        rvRestaurantes.layoutManager = LinearLayoutManager(this)
        rvRestaurantes.setHasFixedSize(true)
    }

    override fun onClickRestaurante(position: Int) {
        adapter.notifyItemChanged(position)
    }

    fun getAllRestaurantes() = arrayListOf(
        Restaurante(
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "22:00",
            "Salada com Molho de Gengibre",
            R.drawable.image1,
            R.drawable.image4
        ),
        Restaurante(
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema, São Paulo",
            "00:00",
            "Camarão ao Bafo",
            R.drawable.image4,
            R.drawable.image1
        ),
        Restaurante(
            "Outback - Moema",
            "Av. Moaci, 187 - Moema, São Paulo",
            "00:00",
            "Brunch",
            R.drawable.image5,
            R.drawable.image3
        ),
        Restaurante(
            "Sí Señor",
            "Alameda Jauaperi, 626 - Moema, São Paulo",
            "01:00",
            "Escondidinho ao Molho Bolonhesa",
            R.drawable.image3,
            R.drawable.image5
        )
    )
}