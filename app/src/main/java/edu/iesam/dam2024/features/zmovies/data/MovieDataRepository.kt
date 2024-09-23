package edu.iesam.dam2024.features.zmovies.data

import edu.iesam.dam2024.features.zmovies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.zmovies.domain.Movie
import edu.iesam.dam2024.features.zmovies.domain.MovieRepository

/**
 * Naming: Modelo + DataRepository
 */
class MovieDataRepository (private val mockRemoteDataSource: MovieMockRemoteDataSource): MovieRepository {
    override fun getMovies(): List<Movie> {
        return mockRemoteDataSource.getMovies()
    }
}