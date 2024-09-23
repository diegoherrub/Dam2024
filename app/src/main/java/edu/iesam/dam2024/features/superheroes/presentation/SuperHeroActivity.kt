package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R

class SuperHeroActivity : AppCompatActivity() {

    private val superHeroFactory : SuperHeroFactory = SuperHeroFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = superHeroFactory.buildViewModel()
        val superHeroes = viewModel.viewCreated()
        Log.d("@dev", superHeroes.toString())
    }
    // cuando la vista es visible para el usuario pero todavía no puede interactuar
    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart")
    }

    // cuando la vista es visible para el usuario y ya puede interactuar
    override fun onResume() {
        super.onResume()
        Log.d("@dev", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@dev", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@dev", "onStop")
    }
}