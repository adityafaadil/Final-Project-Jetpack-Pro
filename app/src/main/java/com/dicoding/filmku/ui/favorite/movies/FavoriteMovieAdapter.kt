package com.dicoding.filmku.ui.favorite.movies

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

class FavoriteMovieAdapter: PagedListAdapter<Movie, FavoriteMovieAdapter.FavoriteMovieViewHolder>(
    DIFF_CALLBACK
) {
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

    fun getSwipedData(swipedPosition: Int): Movie? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemsMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class FavoriteMovieViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemRelease.text = movie.releaseDate
                Glide.with(itemView.context)
                    .load(Constant.POSTER_BASE_URL + movie.imagePath).into(imgPoster)

                itemView.setOnClickListener {
                    Intent(itemView.context, MovieTvDetail::class.java).also {
                        it.putExtra(MovieTvDetail.EXTRA_CATALOGUE, movie.movieId)
                        it.putExtra(MovieTvDetail.EXTRA_TYPE, "movie")
                        itemView.context.startActivity(it)
                    }
                }
            }
        }
    }
}