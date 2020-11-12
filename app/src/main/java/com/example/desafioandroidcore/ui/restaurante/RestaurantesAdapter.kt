package com.example.desafioandroidcore.ui.restaurante

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.R

class RestaurantesAdapter(
    private val listaRestaurantes: ArrayList<Restaurante>,
    val listener: OnClickRestauranteListener
) : RecyclerView.Adapter<RestaurantesAdapter.RestaurantesViewHolder>() {

    var restauranteAdapter: Restaurante =
        Restaurante("", "", "", "", R.drawable.image1, R.drawable.image4)

    interface OnClickRestauranteListener {
        fun onClickRestaurante(position: Int)
    }

    inner class RestaurantesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var tvNomeRestaurante: TextView = itemView.findViewById(R.id.tvNomeRestaurante)
        var tvEnderecoRestaurante: TextView = itemView.findViewById(R.id.tvEnderecoRestaurante)
        var tvHorarioQueFecha: TextView = itemView.findViewById(R.id.tvHorarioQueFecha)
        var ivImgRestaurante: ImageView = itemView.findViewById(R.id.ivImgRestaurante)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                restauranteAdapter = listaRestaurantes[position]
                listener.onClickRestaurante(position)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantesViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_restaurante, parent, false)
        return RestaurantesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantesViewHolder, position: Int) {
        val restaurante = listaRestaurantes[position]

        holder.tvNomeRestaurante.text = restaurante.nome
        holder.tvEnderecoRestaurante.text = restaurante.endereco
        holder.tvHorarioQueFecha.text = restaurante.horarioQueFecha
        holder.ivImgRestaurante.setImageResource(restaurante.img)
    }

    override fun getItemCount() = listaRestaurantes.size
}