package edu.iesam.dam2024.features.zmovies.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.presentation.SuperHeroFactory

class MovieActivity : AppCompatActivity() {

    private val movieFactory : MovieFactory = MovieFactory()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // R son recursos en Android
        val viewModel = movieFactory.buildViewModel()
        val movies = viewModel.viewCreated()
        Log.d("@dev", movies.toString())

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