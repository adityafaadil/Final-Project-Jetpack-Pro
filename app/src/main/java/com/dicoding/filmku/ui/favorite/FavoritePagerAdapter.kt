package com.dicoding.filmku.ui.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.filmku.R
import com.dicoding.filmku.ui.favorite.movies.FavoriteFragmentMovie
import com.dicoding.filmku.ui.favorite.tvShows.FavoriteFragmentTvShow


class FavoritePagerAdapter(private val context: Context, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TAB_TITLES = intArrayOf(R.string.Movie, R.string.TvShow)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when(position) {
            0 -> FavoriteFragmentMovie()
            1 -> FavoriteFragmentTvShow()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence=
        context.resources.getString(TAB_TITLES[position])

}