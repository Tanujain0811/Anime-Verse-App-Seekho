package com.example.seekhoapplication.repo

import com.example.seekhoapplication.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeRepo (private val apiService: ApiService){

        suspend fun fetchTopAnime() = withContext(Dispatchers.IO) {
            apiService.getTopAnime()
        }

        suspend fun fetchAnimeDetails(id: Int) = withContext(Dispatchers.IO) {
            apiService.getAnimeDetails(id)
        }
    }

