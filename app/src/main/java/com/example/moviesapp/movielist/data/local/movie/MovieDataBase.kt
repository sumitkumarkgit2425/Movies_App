package com.example.moviesapp.movielist.data.local.movie

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MovieEntity::class],  //This DB will store data of type MovieEntity
    version = 1
)

abstract class MovieDataBase:RoomDatabase(){

    abstract val MovieDao:MovieDao //This property exposes MovieDao to the rest of the app.
}