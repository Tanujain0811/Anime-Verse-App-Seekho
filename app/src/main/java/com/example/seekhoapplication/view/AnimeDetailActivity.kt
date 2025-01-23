package com.example.seekhoapplication.view

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.seekhoapplication.repo.AnimeRepo
import com.example.seekhoapplication.viewModel.AnimeViewModelFactory
import com.example.seekhoapplication.network.RetrofitInstance
import com.example.seekhoapplication.network.Status
import com.example.seekhoapplication.databinding.ActivityAnimeDetailBinding
import com.example.seekhoapplication.model.AnimeData
import com.example.seekhoapplication.viewModel.AnimeViewModel


class AnimeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeDetailBinding
    private val repository by lazy { AnimeRepo(RetrofitInstance.retrofitService) }
    private val viewModel: AnimeViewModel by viewModels { AnimeViewModelFactory(repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animeId = intent.getIntExtra("anime_id", 0)
        setSupportActionBar(binding.toolbar)

        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set click listener for the back button
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed() // Navigate back when the back button is clicked
        }
        viewModel.fetchAnimeDetails(animeId)

        viewModel.animeDetails.observe(this) { resource ->
            when (resource.status) {
                Status.SUCCESS -> bindData(resource.data!!)
                Status.ERROR -> Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show()
                Status.LOADING -> Toast.makeText(this, "LOADING...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindData(anime: AnimeData) {
        binding.textViewDetailTitle.text = anime.data?.title
        binding.textViewSynopsis.text = anime.data?.synopsis
        binding.textViewEpisodes.text = "Number of Episodes :" + anime.data?.episodes.toString()
        binding.textViewRating.text = "Ratings :" +anime.data?.score.toString()
        binding.textViewGenres.text = "GENRES :"+anime.data?.genres?.joinToString { it.name }

        val embedUrl = anime?.data?.trailer?.url

        // Configure WebView
        if (!embedUrl.isNullOrEmpty()) {
            binding.webView.visibility = View.VISIBLE
            binding.imageViewPosterDetail.visibility = View.GONE
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.settings.loadWithOverviewMode = true
            binding.webView.settings.useWideViewPort = true
            binding.webView.webViewClient = WebViewClient()

            // Load the YouTube embed URL

            binding.webView.loadUrl(embedUrl)
        }
        else{
            binding.webView.visibility = View.GONE
            binding.imageViewPosterDetail.visibility = View.VISIBLE
            Glide.with(this).load(anime?.data?.images?.jpg?.image_url).into(binding.imageViewPosterDetail)
        }
    }
    }

