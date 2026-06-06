package com.example.stickertrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddSticker = findViewById<Button>(R.id.btnAddSticker)
        val btnList = findViewById<Button>(R.id.btnList)
        val btnStats = findViewById<Button>(R.id.btnStats)

        btnAddSticker.setOnClickListener {

            val intent = Intent(this, AddStickerActivity::class.java)
            startActivity(intent)

        }

        btnList.setOnClickListener {

            val intent = Intent(this, StickerListActivity::class.java)
            startActivity(intent)

        }

        btnStats.setOnClickListener {

            val intent = Intent(this, StatsActivity::class.java)
            startActivity(intent)

        }
    }



}

