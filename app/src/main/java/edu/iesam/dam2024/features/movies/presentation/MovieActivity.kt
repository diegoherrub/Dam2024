package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val movieFactory : MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // R son recursos en Android
        val movies = viewModel.viewCreated()
        bindData(movies)
        viewModel.itemSelected(movies.first().id)
        testXml()
    }

    private fun bindData(movies: List<Movie>) { //asignamos datos a elementos de la vista
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_tittle_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val movie1: Movie? = viewModel.itemSelected(movies[0].id)
            movie1?.let {
                //Log.d("@dev", "Pelicula seleccionada: $it") // imprime el objeto entero
                Log.d("@dev", "Pelicula seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_1).text = movies[1].id
        findViewById<TextView>(R.id.movie_tittle_1).text = movies[1].title
        findViewById<TextView>(R.id.movie_id_1).text = movies[2].id
        findViewById<TextView>(R.id.movie_tittle_1).text = movies[2].title
        findViewById<TextView>(R.id.movie_id_1).text = movies[3].id
        findViewById<TextView>(R.id.movie_tittle_1).text = movies[3].title
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

    private fun testXml() {
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = viewModel.itemSelected("1")
        movie?.let {
            xmlDataSource.save(it) //guarda en local la movie seleccionada del viewModel
        }
        val movieSaved = xmlDataSource.find()
        Log.d("@dev", movieSaved.toString())

        xmlDataSource.delete()
    }
}