package com.example.stickertrack

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stickertrack.adapter.StickerAdapter
import com.example.stickertrack.model.Sticker
import com.example.stickertrack.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StickerListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sticker_list)

        val recyclerView =
            findViewById<RecyclerView>(
                R.id.recyclerViewStickers
            )

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        RetrofitClient.api.getStickers()
            .enqueue(object : Callback<List<Sticker>> {

                override fun onResponse(
                    call: Call<List<Sticker>>,
                    response: Response<List<Sticker>>
                ) {

                    if (response.isSuccessful) {

                        val stickers =
                            response.body()?.toMutableList()
                                ?: mutableListOf()

                        recyclerView.adapter =
                            StickerAdapter(stickers)

                    }

                }

                override fun onFailure(
                    call: Call<List<Sticker>>,
                    t: Throwable
                ) {

                    Toast.makeText(
                        this@StickerListActivity,
                        "Erro: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()

                }

            })

    }

}
