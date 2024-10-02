package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

// https://developer.android.com/training/data-storage/shared-preferences?hl=es-419
// val sharedPref = activity?.getSharedPreferences(
//        getString(R.string.preference_file_key), Context.MODE_PRIVATE)

class MovieXmlLocalDataSource (private val context: Context){

    val sharedPref = context.getSharedPreferences(
        //obtenemos el contenido de res/values/strings.xml (name_file_xml)
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    //val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
    //with (sharedPref.edit()) {
    //    putInt(getString(R.string.saved_high_score_key), newHighScore)
    //    apply()
    //}
    // commit() escribe de forma síncrona
    // apply() escribe de forma asíncrona
    // nos permite guardar una unica película
    fun save(movie: Movie) {
        //val editor = sharedPref.edit()
        //editor.putString("id", movie.id)
        //editor.putString("title", movie.title)
        //editor.putString("poster", movie.poster)
        //editor.apply()

        //sharedPref.edit().apply {
        //    putString("id", movie.id)
        //    putString("title", movie.title)
        //    putString("poster", movie.poster)
        //    apply()
        //}
        val editor = sharedPref.edit()
        editor.putString(movie.id, gson.toJson(movie))
        editor.apply()
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    // obtener película
    //fun find(): Movie{
    //    //val id = sharedPref.getString("id", "")
    //    //val title = sharedPref.getString("title", "")
    //    //val poster = sharedPref.getString("poster", "")
    //    //return Movie(id!!, title!!, poster!!) // !! fuerza a que no sea nulo. porque sabemos que no es nulo
    //    sharedPref.apply {
    //        return Movie (
    //            getString("id", "")!!,
    //            getString("title", "")!!,
    //            getString("poster", "")!!
    //        )
    //    }
    //}

    fun findAll(): List<Movie> {
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all //as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun findById(movieId:String): Movie?{
        return sharedPref.getString(movieId, null)?.let { movie ->
            gson.fromJson(movie, Movie::class.java)
        }
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }
    
    fun deleteById(movieId: String) {
        sharedPref.edit().remove(movieId).commit()
    }
}