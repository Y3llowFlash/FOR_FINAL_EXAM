package com.example.inventoryapp.data.repository

import androidx.lifecycle.LiveData
import com.example.inventoryapp.data.local.Movie
import com.example.inventoryapp.data.local.MovieDao

class MovieRepository(private val movieDao: MovieDao) {
    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()
    val lowRatingMovies: LiveData<List<Movie>> = movieDao.getLowRatingMovies()

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMoviesByTitle(title: String) {
        movieDao.deleteMoviesByExactTitle(title)
    }
}
