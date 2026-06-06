package com.example.stickertrack.model

data class Sticker(

    val id: Int? = null,

    val numero: Int,
    val jogador: String,
    val selecao: String,
    val raridade: String,

    val tenho: Boolean,
    val colada: Boolean,
    val repetida: Boolean


)
