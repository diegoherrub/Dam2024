package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroMockRemoteDataSource {

    fun getSuperHeroes(): List<SuperHero> {
        return listOf(
            SuperHero("1", "Spiderman", "blue"),
            SuperHero("2", "Wolverine", "yellow"),
            SuperHero("3", "Batman", "black"),
            SuperHero(color = "Red", id = " 4", name = "Moevius")
        )
    }
}