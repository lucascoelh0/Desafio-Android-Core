package com.example.desafioandroidcore.ui.restaurante

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.R

class CardapioFragment : Fragment(), CardapioAdapter.OnClickCardapioListener {

    var restaurante: Restaurante? = null
    var listaPratos: ArrayList<String?>? = null
    lateinit var adapter: CardapioAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cardapio, container, false)

        restaurante = arguments?.let { CardapioFragmentArgs.fromBundle(it).restaurante }
        listaPratos = getAllPratos()

        adapter = restaurante?.let { CardapioAdapter(listaPratos!!, it, this) }!!

        val recyclerView = view?.findViewById<RecyclerView>(R.id.rvPratos)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = GridLayoutManager(context, 2)
        recyclerView?.setHasFixedSize(true)



        restaurante?.img?.let {
            view.findViewById<ImageView>(R.id.ivImgRestauranteCardapio).setImageResource(
                it
            )
        }

        restaurante?.nome?.let {
            view.findViewById<TextView>(R.id.tvNomeRestauranteCardapio).text = it
        }

        return view
    }

    override fun onClickCardapio(position: Int) {
        findNavController().navigate(R.id.action_cardapioFragment_to_pratoFragment)
    }

    fun getAllPratos(): ArrayList<String?> {
        val lista: ArrayList<String?> = ArrayList()

        for (i in 1..10) {
            lista.add(restaurante?.pratoPrincipal)
        }

        return lista
    }


//            = arrayListOf(
//        restaurante?.pratoPrincipal
//    )
}