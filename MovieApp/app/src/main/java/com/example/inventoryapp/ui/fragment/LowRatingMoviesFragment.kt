package com.example.inventoryapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.adapter.MovieAdapter
import com.example.inventoryapp.ui.viewmodel.MovieViewModel

class LowRatingMoviesFragment : Fragment() {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_low_rating_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewLowRatingMovies)
        movieAdapter = MovieAdapter()

        recyclerView.adapter = movieAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        movieViewModel.lowRatingMovies.observe(viewLifecycleOwner) { movies ->
            movieAdapter.setData(movies)
        }
    }
}
