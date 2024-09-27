package edu.iesam.dam2024.features.superheroes.presentation

import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.superheroes.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.SuperHeroRepository

class SuperHeroFactory {
    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            GetSuperHeroesUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource())),
            GetSuperHeroUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource()))
        )
    }
}