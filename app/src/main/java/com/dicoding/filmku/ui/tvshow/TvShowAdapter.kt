package com.dicoding.filmku.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.filmku.Constant
import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.databinding.ItemTvBinding
import com.dicoding.filmku.ui.detail.MovieTvDetail

class TvShowAdapter : PagedListAdapter<TvShow, TvShowAdapter.CatalogueViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.showId == newItem.showId
            }

            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueViewHolder {
        val tvShowBinding = ItemTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogueViewHolder(tvShowBinding)
    }

    override fun onBindViewHolder(holder: CatalogueViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null)
        holder.bind(tvShow)
    }

    class CatalogueViewHolder(private val binding: ItemTvBinding): RecyclerView.ViewHolder(binding.root)  {
        fun bind(content: TvShow) {
            with(binding) {
                tvItemTitle.text = content.title
                tvItemRelease.text = content.firstAirDate
                Glide.with(itemView.context)
                        .load(Constant.POSTER_BASE_URL + content.imagePath).into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MovieTvDetail::class.java)
                    intent.putExtra(MovieTvDetail.EXTRA_CATALOGUE, content.showId)
                    intent.putExtra(MovieTvDetail.EXTRA_TYPE, "tv")

                    itemView.context.startActivity(intent)
                }
            }
        }
    }


}