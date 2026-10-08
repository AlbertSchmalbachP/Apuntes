import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 1: crea primero etCiudad, btnSaludar y tvResultado en XML.
        // 2: localiza etNombre, etCiudad, btnSaludar y tvResultado.
        val nombre = findViewById<EditText>(R.id.etNombre)
        val ciudad = findViewById<EditText>(R.id.etCiudad)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val boton = findViewById<Button>(R.id.btnSaludar)
        // 3: añade el listener; lee, recorta y valida los dos textos.
        boton.setOnClickListener() {
            val nombreConv: String = nombre.text.toString().trim()
            val ciudadConv: String = ciudad.text.toString().trim()
            if (nombreConv.isEmpty()) { // ".isEmpty() es igual a ".length() == 0"
                resultado.text = "Por favor, introduce un nombre."
            } else if (ciudadConv.length == 0) {
                resultado.text = "Por favor, introduce una ciudad."
            } else {
                // 4: construye un mensaje con plantillas de texto.
                resultado.text = "¡Hola, $nombreConv! Tu ciudad es $ciudadConv."
            }
        }
    }
}