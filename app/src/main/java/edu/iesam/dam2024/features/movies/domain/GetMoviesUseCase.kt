package edu.iesam.dam2024.features.movies.domain

/**
 * Naming: Verbo(Acción) + Use Case
 * Casos de uso siempre es una acción, y solo hace una cosa
 */
class GetMoviesUseCase (private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }
}