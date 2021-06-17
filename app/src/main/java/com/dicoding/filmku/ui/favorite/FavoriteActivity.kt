package com.dicoding.filmku.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.filmku.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var favoriteBinding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        val favoritePagerAdapter = FavoritePagerAdapter(this, supportFragmentManager)
        favoriteBinding.viewPager.adapter = favoritePagerAdapter
        favoriteBinding.tabFavorite.setupWithViewPager(favoriteBinding.viewPager)

        supportActionBar?.title = "Favorite"
        supportActionBar?.elevation = 0f
    }
}