package com.example.moviesapp.DI
import android.app.Application
import androidx.room.Room
import com.example.moviesapp.movielist.data.local.movie.MovieDataBase
import com.example.moviesapp.movielist.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply{
        level = HttpLoggingInterceptor.Level.BODY
    //helps in logging the request and response from the server
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    //Core HTTP engine for Retrofit; handles all network tasks

    @Provides
    @Singleton
    fun providesMovieApi(): MovieApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MovieApi.BASE_URL)
            .client(client)
            .build()
            .create(MovieApi::class.java)
       // Tells Hilt how to build the MovieApi interface.
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(app: Application):MovieDataBase{
        return Room.databaseBuilder(
            app,
            MovieDataBase::class.java,
            "moviedb.db"
        ).build()

    //Provides a singleton Room database called "moviedb.db".
    //Takes Application context to initialize it.
    }
}