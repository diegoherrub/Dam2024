package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

// recoger los eventos que pasan los eventos en la vista y ejecutar los casos de uso
// pintar en la vista lo que generan los casos de uso
class MovieDetailViewModel (
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    fun viewCreated(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }
}