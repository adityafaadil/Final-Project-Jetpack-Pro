package com.dicoding.filmku.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.filmku.Constant
import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.databinding.ItemMovieBinding
import com.dicoding.filmku.ui.detail.MovieTvDetail

class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.CatalogueViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueViewHolder {
        val itemsMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogueViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: CatalogueViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null)
        holder.bind(movie)
    }

    class CatalogueViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(content: Movie) {
            with(binding) {
                tvItemTitle.text = content.title
                tvItemRelease.text = content.releaseDate
                Glide.with(itemView.context)
                    .load(Constant.POSTER_BASE_URL + content.imagePath).into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MovieTvDetail::class.java)
                    intent.putExtra(MovieTvDetail.EXTRA_CATALOGUE,content.movieId)
                    intent.putExtra(MovieTvDetail.EXTRA_TYPE, "movie")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}