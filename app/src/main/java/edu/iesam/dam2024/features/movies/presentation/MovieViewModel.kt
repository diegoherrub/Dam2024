package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

// recoger los eventos que pasan los eventos en la vista y ejecutar los casos de uso
// pintar en la vista lo que generan los casos de uso
class MovieViewModel (private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }
}