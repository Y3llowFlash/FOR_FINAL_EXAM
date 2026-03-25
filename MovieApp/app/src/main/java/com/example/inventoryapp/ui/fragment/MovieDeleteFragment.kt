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
import com.example.inventoryapp.ui.viewmodel.MovieViewModel

class MovieDeleteFragment : Fragment() {
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_movie_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        val titleEditText = view.findViewById<EditText>(R.id.editTextDeleteMovieTitle)
        val deleteButton = view.findViewById<Button>(R.id.buttonDeleteMovie)

        deleteButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()

            if (title.isNotEmpty()) {
                movieViewModel.deleteMovieByTitle(title)
                Toast.makeText(requireContext(), "Successfully Deleted!", Toast.LENGTH_SHORT).show()
                titleEditText.text.clear()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter a valid item name!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
