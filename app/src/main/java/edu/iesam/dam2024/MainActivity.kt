package edu.iesam.dam2024

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // private val varInmutable: String = "Hola"
    // private var varMutable: String = "Hola"

    private var name: String = "Diego"
    private var name2: String? = null // le decimos que la variable puede ser nula con el ? en el tipo
    private var name3: String = null // si no se lo marcamos (?) nos avisa de error

    // inicia los contructores
    // init {
    //     name = "Diego"
    // }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // R son recursos en Android

        //Scope Function
        // si el name no es nulo ejecuta el codigo
        name2?.let { nameNotNull ->
            Log.d("@dev", nameNotNull)
        }

        // si no es nulo (it) hace referencia a name2
        name2 = "Alumno"
        name2?.let {
            Log.d("@dev", it)
        }

        // fuerza a imprimir el contenido de la variable, se nulo o no, si es nulo la app crasheará
        Log.d("@dev", name3!!)

    }
}