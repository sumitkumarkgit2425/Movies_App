package com.example.moviesapp.details.presentation

import com.example.moviesapp.movielist.Domain.Model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)