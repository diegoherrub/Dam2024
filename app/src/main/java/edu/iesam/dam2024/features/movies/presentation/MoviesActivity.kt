package edu.iesam.dam2024.features.movies.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies) // R son recursos en Android

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        val movies = viewModel.viewCreated()
        bindData(movies)

    }

    private fun bindData(movies: List<Movie>) { //asignamos datos a elementos de la vista
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }
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

    //private fun testXml() {
    //    val xmlDataSource = MovieXmlLocalDataSource(this)
    //    val movie = viewModel.itemSelected("1")
    //    movie?.let {
    //        xmlDataSource.save(it) //guarda en local la movie seleccionada del viewModel
    //    }
    //    val movieSaved = xmlDataSource.find()
    //    Log.d("@dev", movieSaved.toString())
    //
    //    xmlDataSource.delete()
    //}

    //private fun testListXml() {
    //    val movies = viewModel.viewCreated()
    //    val xmlDataSource = MovieXmlLocalDataSource(this)
    //    xmlDataSource.saveAll(movies)
    //
    //    val moviesFromXml = xmlDataSource.findAll()
    //    Log.d("@dev", moviesFromXml.toString())
    //}
    //
    //private fun testMovie(){
    //    viewModel.viewCreated()
    //    val xmlDataSource = MovieXmlLocalDataSource(this)
    //    val movie = xmlDataSource.findById("1")
    //    Log.d("@dev", "$movie")
    //}

    private fun navigateToMovieDetail(movieId: String) {
        startActivity(MovieDetailActivity.getIntent(this, movieId))
    }
}