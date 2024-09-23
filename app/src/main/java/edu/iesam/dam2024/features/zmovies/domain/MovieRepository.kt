package edu.iesam.dam2024.features.zmovies.domain

interface MovieRepository {
    fun getMovies(): List<Movie>
}