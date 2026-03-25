package com.example.inventoryapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.inventoryapp.R
import com.example.inventoryapp.data.local.Movie
import com.example.inventoryapp.ui.viewmodel.MovieViewModel

class MovieInsertFragment : Fragment() {
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_movie_insert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        val titleEditText = view.findViewById<EditText>(R.id.editTextMovieTitle)
        val directorEditText = view.findViewById<EditText>(R.id.editTextMovieDirector)
        val yearEditText = view.findViewById<EditText>(R.id.editTextMovieReleaseYear)
        val ratingEditText = view.findViewById<EditText>(R.id.editTextMovieRating)
        val addButton = view.findViewById<Button>(R.id.buttonAddMovie)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val director = directorEditText.text.toString().trim()
            val releaseYearText = yearEditText.text.toString().trim()
            val ratingText = ratingEditText.text.toString().trim()

            if (title.isEmpty() || director.isEmpty() || releaseYearText.isEmpty() || ratingText.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val releaseYear = releaseYearText.toIntOrNull()
            val rating = ratingText.toDoubleOrNull()

            if (releaseYear == null || rating == null) {
                Toast.makeText(requireContext(), "Please enter valid values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val movie = Movie(
                id = 0,
                title = title,
                director = director,
                releaseYear = releaseYear,
                rating = rating
            )

            movieViewModel.insertMovie(movie)
            Toast.makeText(requireContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show()

            titleEditText.text.clear()
            directorEditText.text.clear()
            yearEditText.text.clear()
            ratingEditText.text.clear()
        }
    }
}
