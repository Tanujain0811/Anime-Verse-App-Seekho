package com.example.seekhoapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seekhoapplication.databinding.ItemAniemeBinding
import com.example.seekhoapplication.model.Anime

class AnimeListAdapter(private val onItemClick: (Anime) -> Unit) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    private val animeList = mutableListOf<Anime>()

    fun submitList(list: List<Anime>?) {
        animeList.clear()
        if (list != null) animeList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAniemeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount() = animeList.size

    inner class AnimeViewHolder(private val binding: ItemAniemeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime) {
            binding.textViewTitle.text = anime.title
            binding.textViewEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
            binding.textViewRating.text = "Rating: ${anime.score ?: "N/A"}"
            Glide.with(binding.imageViewPoster).load(anime.images.jpg.image_url).into(binding.imageViewPoster)

            binding.root.setOnClickListener { onItemClick(anime) }
        }
    }
}
