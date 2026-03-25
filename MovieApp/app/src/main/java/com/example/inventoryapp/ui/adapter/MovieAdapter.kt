package com.example.inventoryapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.data.local.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieList = emptyList<Movie>()

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textViewMovieTitle)
        val directorTextView: TextView = itemView.findViewById(R.id.textViewMovieDirector)
        val yearTextView: TextView = itemView.findViewById(R.id.textViewMovieReleaseYear)
        val ratingTextView: TextView = itemView.findViewById(R.id.textViewMovieRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.titleTextView.text = currentMovie.title
        holder.directorTextView.text = currentMovie.director
        holder.yearTextView.text = currentMovie.releaseYear.toString()
        holder.ratingTextView.text = "${currentMovie.rating}**"
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setData(movies: List<Movie>) {
        movieList = movies
        notifyDataSetChanged()
    }
}
