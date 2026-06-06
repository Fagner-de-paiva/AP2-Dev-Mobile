package com.example.stickertrack

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.stickertrack.model.Sticker
import com.example.stickertrack.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddStickerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sticker)

        val editNumero = findViewById<EditText>(R.id.editNumero)
        val editJogador = findViewById<EditText>(R.id.editJogador)
        val editSelecao = findViewById<EditText>(R.id.editSelecao)

        val spinnerRaridade = findViewById<Spinner>(R.id.spinnerRaridade)

        val checkTenho = findViewById<CheckBox>(R.id.checkTenho)
        val checkColada = findViewById<CheckBox>(R.id.checkColada)
        val checkRepetida = findViewById<CheckBox>(R.id.checkRepetida)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        val raridades = arrayOf(
            "Comum",
            "Rara",
            "Ultra Rara"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            raridades
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerRaridade.adapter = adapter

        btnSalvar.setOnClickListener {

            val sticker = Sticker(

                numero = editNumero.text.toString().toInt(),
                jogador = editJogador.text.toString(),
                selecao = editSelecao.text.toString(),
                raridade = spinnerRaridade.selectedItem.toString(),

                tenho = checkTenho.isChecked,
                colada = checkColada.isChecked,
                repetida = checkRepetida.isChecked

            )

            RetrofitClient.api.createSticker(sticker)
                .enqueue(object : Callback<Sticker> {

                    override fun onResponse(
                        call: Call<Sticker>,
                        response: Response<Sticker>
                    ) {

                        Toast.makeText(
                            this@AddStickerActivity,
                            "Figurinha salva!",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                    override fun onFailure(
                        call: Call<Sticker>,
                        t: Throwable
                    ) {

                        Toast.makeText(
                            this@AddStickerActivity,
                            "Erro: ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()

                    }

                })

        }

    }


}
