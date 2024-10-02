package edu.iesam.dam2024.features.superheroes.data.local

import android.content.Context
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroXmlLocalDataSource (private val context: Context) {

    val sharedPref = context.getSharedPreferences(
        "superheroes", Context.MODE_PRIVATE)

    fun save(superHero: SuperHero) {
        sharedPref.edit().apply {
            putString("id", superHero.id)
            putString("name", superHero.name)
            putString("color", superHero.color)
            apply()
        }
    }

    fun find(): SuperHero {
        sharedPref.apply {
            return SuperHero(
                getString("id", "")!!,
                getString("name", "")!!,
                getString("color", "")!!
            )
        }
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }


}