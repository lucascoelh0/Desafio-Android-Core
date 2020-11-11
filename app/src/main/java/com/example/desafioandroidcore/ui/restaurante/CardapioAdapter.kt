package com.example.desafioandroidcore.ui.restaurante

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.R

class CardapioAdapter(
    val listaPratos: ArrayList<String?>,
    val restaurante: Restaurante,
    val listener: OnClickCardapioListener
) : RecyclerView.Adapter<CardapioAdapter.CardapioViewHolder>() {

    interface OnClickCardapioListener {
        fun onClickCardapio(position: Int)
    }

    inner class CardapioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)
        var ivImgPrato: ImageView = itemView.findViewById(R.id.ivImgPrato)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickCardapio(position)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardapioAdapter.CardapioViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_prato, parent, false)
        return CardapioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardapioViewHolder, position: Int) {
        holder.ivImgPrato.setImageResource(restaurante.imgPratoPrincipal)
        holder.tvNomePrato.text = restaurante.pratoPrincipal
    }

    override fun getItemCount() = listaPratos.size
}
