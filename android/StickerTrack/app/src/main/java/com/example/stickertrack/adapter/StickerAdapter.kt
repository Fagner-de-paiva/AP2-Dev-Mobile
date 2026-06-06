package com.example.stickertrack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.stickertrack.R
import com.example.stickertrack.model.Sticker
import com.example.stickertrack.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StickerAdapter(
    private val stickers: MutableList<Sticker>
) : RecyclerView.Adapter<StickerAdapter.StickerViewHolder>() {


    class StickerViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val textNumero: TextView =
            itemView.findViewById(R.id.textNumero)

        val textJogador: TextView =
            itemView.findViewById(R.id.textJogador)

        val textSelecao: TextView =
            itemView.findViewById(R.id.textSelecao)

        val textRaridade: TextView =
            itemView.findViewById(R.id.textRaridade)

        val btnDelete: Button =
            itemView.findViewById(R.id.btnDelete)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StickerViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sticker, parent, false)

        return StickerViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: StickerViewHolder,
        position: Int
    ) {

        val sticker = stickers[position]

        holder.textNumero.text =
            "Número: ${sticker.numero}"

        holder.textJogador.text =
            "Jogador: ${sticker.jogador}"

        holder.textSelecao.text =
            "Seleção: ${sticker.selecao}"

        holder.textRaridade.text =
            "Raridade: ${sticker.raridade}"

        holder.btnDelete.setOnClickListener {

            sticker.id?.let { id ->

                RetrofitClient.api.deleteSticker(id)
                    .enqueue(object :
                        Callback<Map<String, String>> {

                        override fun onResponse(
                            call: Call<Map<String, String>>,
                            response: Response<Map<String, String>>
                        ) {

                            stickers.removeAt(position)
                            notifyItemRemoved(position)

                            Toast.makeText(
                                holder.itemView.context,
                                "Figurinha deletada",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                        override fun onFailure(
                            call: Call<Map<String, String>>,
                            t: Throwable
                        ) {

                            Toast.makeText(
                                holder.itemView.context,
                                "Erro ao deletar",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    })

            }

        }

    }

    override fun getItemCount(): Int {

        return stickers.size

    }


}
