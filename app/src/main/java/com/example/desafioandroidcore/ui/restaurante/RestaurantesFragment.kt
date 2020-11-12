package com.example.desafioandroidcore.ui.restaurante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.R

class RestaurantesFragment : Fragment(), RestaurantesAdapter.OnClickRestauranteListener {

    var listaRestaurantes = getAllRestaurantes()
    var adapter = RestaurantesAdapter(listaRestaurantes, this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_restaurantes, container, false)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.rvRestaurantes)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.setHasFixedSize(true)

        return view
    }

    override fun onClickRestaurante(position: Int) {

        val action =
            RestaurantesFragmentDirections.actionRestaurantesFragmentToCardapioFragment(adapter.restauranteAdapter)

        findNavController().navigate(action)
    }

    private fun getAllRestaurantes() = arrayListOf(
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