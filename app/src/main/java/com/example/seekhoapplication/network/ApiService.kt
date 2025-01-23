package com.example.seekhoapplication.network

import com.example.seekhoapplication.model.AnimeData
import com.example.seekhoapplication.model.TopAnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
        @GET("top/anime")
        suspend fun getTopAnime(): Response<TopAnimeResponse>

        @GET("anime/{id}")
        suspend fun getAnimeDetails(@Path("id") id: Int): Response<AnimeData>
    }

