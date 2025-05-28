package com.example.moviesapp.movielist.Domain.Repository

import com.example.moviesapp.movielist.Domain.Model.Movie
import com.example.moviesapp.movielist.Utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>

}