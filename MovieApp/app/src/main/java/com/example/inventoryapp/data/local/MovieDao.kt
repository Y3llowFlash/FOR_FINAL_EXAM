package com.example.inventoryapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movies WHERE rating < 5 ORDER BY id ASC")
    fun getLowRatingMovies(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movie: Movie)

    @Query("DELETE FROM movies WHERE title = :title")
    suspend fun deleteMoviesByExactTitle(title: String)
}
