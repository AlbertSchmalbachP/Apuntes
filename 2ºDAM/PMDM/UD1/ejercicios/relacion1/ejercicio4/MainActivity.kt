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
        val nota = findViewById<EditText>(R.id.etNota)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val boton = findViewById<Button>(R.id.btnEvaluar)

        boton.setOnClickListener {
            // convierte y valida nota (Int entre 0 y 10).
            val notaConv : Int? = nota.text.toString().toIntOrNull()
            if (notaConv == null || notaConv > 10 || notaConv < 0) {
                resultado.text = "Nota no válida."
            } else {
                // si es válida usa when para asignar la calificación.
                // muestra el resultado o el error.
                when {
                    notaConv < 5 -> resultado.text = "Suspenso."
                    notaConv < 7 -> resultado.text = "Aprobado."
                    notaConv < 9 -> resultado.text = "Notable."
                    else -> resultado.text = "Sobresaliente."
                }
            }
        }
    }
}
