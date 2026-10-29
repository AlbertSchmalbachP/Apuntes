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
        val tarjeta = findViewById<TextView>(R.id.tvTarjeta)
        val boton = findViewById<Button>(R.id.btnPresentar)

        // Declara nombre (String), edad (Int) e intentos (var Int).
        val nombre: String = "Albert";
        val edad: Int = 19;
        var intentos: Int = 0;
        // En el clic aumenta intentos, escribe la tarjeta y usa Log.d.
        boton.setOnClickListener {
            intentos++
            tarjeta.text = "Mi nombre es $nombre, tengo $edad años y lo he intentado $intentos veces."
        }
    }
}