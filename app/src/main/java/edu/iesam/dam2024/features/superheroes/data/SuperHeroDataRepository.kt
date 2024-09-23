package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.domain.SuperHeroRepository

class SuperHeroDataRepository (private val mockRemoteDataSource: SuperHeroMockRemoteDataSource): SuperHeroRepository {
    override fun getSuperHeroes(): List<SuperHero> {
        return  mockRemoteDataSource.getSuperHeroes()
    }
}