package edu.iesam.dam2024.features.zmovies.presentation

import edu.iesam.dam2024.features.zmovies.data.MovieDataRepository
import edu.iesam.dam2024.features.zmovies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.zmovies.domain.GetMoviesUseCase

class MovieFactory {

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel(GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())))
    }
}