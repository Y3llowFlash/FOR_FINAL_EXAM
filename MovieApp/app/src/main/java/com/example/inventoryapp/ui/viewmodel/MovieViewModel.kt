package com.example.inventoryapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.inventoryapp.data.local.Movie
import com.example.inventoryapp.data.local.MovieDatabase
import com.example.inventoryapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MovieRepository
    val allMovies: LiveData<List<Movie>>
    val lowRatingMovies: LiveData<List<Movie>>

    init {
        val movieDao = MovieDatabase.getDatabase(application).movieDao()
        repository = MovieRepository(movieDao)
        allMovies = repository.allMovies
        lowRatingMovies = repository.lowRatingMovies
    }

    fun insertMovie(movie: Movie) {
        viewModelScope.launch {
            repository.insertMovie(movie)
        }
    }

    fun deleteMovieByTitle(title: String) {
        viewModelScope.launch {
            repository.deleteMoviesByTitle(title)
        }
    }
}
