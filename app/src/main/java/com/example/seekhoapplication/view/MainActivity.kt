package com.example.seekhoapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seekhoapplication.adapter.AnimeListAdapter
import com.example.seekhoapplication.repo.AnimeRepo
import com.example.seekhoapplication.viewModel.AnimeViewModelFactory
import com.example.seekhoapplication.R
import com.example.seekhoapplication.network.RetrofitInstance
import com.example.seekhoapplication.network.Status
import com.example.seekhoapplication.viewModel.AnimeViewModel

class MainActivity : AppCompatActivity() {
        private val repository by lazy { AnimeRepo(RetrofitInstance.retrofitService) }

        private val viewModel: AnimeViewModel by viewModels { AnimeViewModelFactory(repository) }
        private lateinit var adapter: AnimeListAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            setupRecyclerView()

            // Observe topAnime LiveData
            viewModel.topAnime.observe(this) { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        adapter.submitList(resource.data?.data)
                        // Hide loading indicator
                    }
                    Status.ERROR -> {
                        // Show error message
                    }
                    Status.LOADING -> {
                        // Show loading indicator
                    }
                }
            }

            // Fetch top anime when the activity starts
            viewModel.fetchTopAnime()
        }

        private fun setupRecyclerView() {
            adapter = AnimeListAdapter { anime ->
                val intent = Intent(this, AnimeDetailActivity::class.java)
                intent.putExtra("anime_id", anime.mal_id)
                startActivity(intent)
            }
            findViewById<RecyclerView>(R.id.recyclerViewAnime).apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = this@MainActivity.adapter
            }
        }
    }