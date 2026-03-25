package com.example.inventoryapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val director: String,
    val releaseYear: Int,
    val rating: Double
)
