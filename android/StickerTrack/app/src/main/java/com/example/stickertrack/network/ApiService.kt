package com.example.stickertrack.network

import com.example.stickertrack.model.Sticker
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Path
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @POST("stickers")
    fun createSticker(
        @Body sticker: Sticker
    ): Call<Sticker>

    @GET("stickers")
    fun getStickers(): Call<List<Sticker>>

    @DELETE("stickers/{id}")
    fun deleteSticker(
        @Path("id") id: Int
    ): Call<Map<String, String>>


}
