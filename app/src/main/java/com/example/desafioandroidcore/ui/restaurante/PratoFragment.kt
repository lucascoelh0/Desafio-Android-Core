package com.example.desafioandroidcore.ui.restaurante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.desafioandroidcore.R


class PratoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_prato, container, false)

        val restaurante = arguments?.let { PratoFragmentArgs.fromBundle(it).restaurantePrato }

        view.findViewById<ImageView>(R.id.ivImgPratoDetalhe)
            .setImageResource(restaurante!!.imgPratoPrincipal)
        view.findViewById<TextView>(R.id.tvNomePratoDetalhe).text = restaurante.pratoPrincipal
        view.findViewById<TextView>(R.id.tvDescricaoPrato).text = getDescricao()

        return view
    }

    fun getDescricao() =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dapibus nisi at nisi fringilla, nec euismod felis tincidunt. Vestibulum condimentum gravida nulla, ac pellentesque lectus feugiat ullamcorper. "
}