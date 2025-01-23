package com.example.seekhoapplication.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.example.seekhoapplication.repo.AnimeRepo
import com.example.seekhoapplication.network.Resource
import com.example.seekhoapplication.model.AnimeData
import com.example.seekhoapplication.model.TopAnimeResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeViewModel(private val repository: AnimeRepo) : ViewModel() {

    private val _topAnime = MutableLiveData<Resource<TopAnimeResponse>>()
    val topAnime: LiveData<Resource<TopAnimeResponse>> get() = _topAnime

    private val _animeDetails = MutableLiveData<Resource<AnimeData>>()
    val animeDetails: LiveData<Resource<AnimeData>> get() = _animeDetails

    /**
     * Fetches the top anime list using Coroutines
     */
    fun fetchTopAnime() {
        _topAnime.postValue(Resource.loading(null)) // Emit loading state
        viewModelScope.launch {
            try {
                val response = repository.fetchTopAnime()
                _topAnime.postValue(handleResponse(response))
            } catch (e: Exception) {
                _topAnime.postValue(Resource.error("Error fetching anime list", null))
            }
        }
    }

    /**
     * Fetches details of a specific anime by ID using Coroutines
     */
    fun fetchAnimeDetails(id: Int) {
        _animeDetails.postValue(Resource.loading(null)) // Emit loading state
        viewModelScope.launch {
            try {
                val response = repository.fetchAnimeDetails(id)
                _animeDetails.postValue(handleResponse(response))
            } catch (e: Exception) {
                _animeDetails.postValue(Resource.error("Error fetching anime details", null))
            }
        }
    }

    /**
     * Helper function to handle API responses
     */
    private fun <T> handleResponse(response: Response<T>): Resource<T> {
        return if (response.isSuccessful && response.body() != null) {
            Resource.success(response.body()!!)
        } else {
            Resource.error(response.message(), null)
        }
    }
}

