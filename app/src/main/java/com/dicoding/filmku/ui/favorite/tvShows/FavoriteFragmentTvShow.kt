package com.dicoding.filmku.ui.favorite.tvShows

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
import com.dicoding.filmku.databinding.FragmentFavoriteTvShowBinding
import com.dicoding.filmku.ui.favorite.FavoriteViewModel
import com.dicoding.filmku.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteFragmentTvShow : Fragment() {

    private lateinit var fragmentFavoriteTvBinding: FragmentFavoriteTvShowBinding
    private lateinit var favoriteTvAdapter: FavoriteTvAdapter
    private lateinit var viewModel: FavoriteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentFavoriteTvBinding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return fragmentFavoriteTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavoriteTvBinding.rvShow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteTvAdapter = FavoriteTvAdapter()
            fragmentFavoriteTvBinding.progressBar.visibility = View.VISIBLE
            viewModel.getListFavTv().observe(viewLifecycleOwner, { tv ->
                fragmentFavoriteTvBinding.progressBar.visibility = View.GONE
                favoriteTvAdapter.submitList(tv)
            })

            with(fragmentFavoriteTvBinding.rvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = favoriteTvAdapter
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
                val tvShowEntity = favoriteTvAdapter.getSwipedData(swipedPosition)

                tvShowEntity?.let {
                    viewModel.setListFavTv(it)
                }
                val snackBar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_ok) { _ ->
                    tvShowEntity?.let {
                        viewModel.setListFavTv(it)
                    }
                }
                snackBar.show()
            }
        }
    })
}