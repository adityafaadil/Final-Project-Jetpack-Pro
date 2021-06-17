package com.dicoding.filmku.ui.favorite.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.filmku.R
import com.dicoding.filmku.databinding.FragmentFavoriteMovieBinding
import com.dicoding.filmku.ui.favorite.FavoriteViewModel
import com.dicoding.filmku.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteFragmentMovie : Fragment() {

    private lateinit var fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter
    private lateinit var viewModel: FavoriteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return fragmentFavoriteMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavoriteMovieBinding.rvMovie)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            favoriteMovieAdapter = FavoriteMovieAdapter()

            fragmentFavoriteMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getListFavMovie().observe(viewLifecycleOwner, { movie ->
                fragmentFavoriteMovieBinding.progressBar.visibility = View.GONE
                favoriteMovieAdapter.submitList(movie)

            })

            with(fragmentFavoriteMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = favoriteMovieAdapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.absoluteAdapterPosition
                val movieEntity = favoriteMovieAdapter.getSwipedData(swipedPosition)

                movieEntity?.let {
                    viewModel.setListFavMovie(it)
                }
                val snackBar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_ok) { _ ->
                    movieEntity?.let {
                        viewModel.setListFavMovie(it)
                    }
                }
                snackBar.show()
            }
        }
    })
}