package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {

    private val superHeroFactory : SuperHeroFactory = SuperHeroFactory()
    private val viewModel = superHeroFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        val superHeroes = viewModel.viewCreated()
        //bindData(superHeroes)
        viewModel.itemSelected(superHeroes.first().id)
        testXml()
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        findViewById<TextView>(R.id.hero_id_1).text = superHeroes[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superHeroes[0].name
        findViewById<TextView>(R.id.layout_1).setOnClickListener {
            val superHero1: SuperHero? = viewModel.itemSelected(superHeroes[0].id)
            superHero1?.let{
                Log.d("@dev", "Super Héroe seleccionado: ${it.name}")
            }
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

    private fun testXml() {
        val xmlDataSource = SuperHeroXmlLocalDataSource(this)
        val heroe = viewModel.itemSelected("1")
        heroe?.let {
            xmlDataSource.save(it)
        }
        val heroeSaved = xmlDataSource.find()
        Log.d("@dev", heroeSaved.toString())

        xmlDataSource.delete()
    }
}