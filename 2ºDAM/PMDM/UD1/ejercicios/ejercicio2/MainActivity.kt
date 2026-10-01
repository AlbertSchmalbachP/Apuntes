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
        val precio = findViewById<EditText>(R.id.etPrecio)
        val cantidad = findViewById<EditText>(R.id.etCantidad)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val boton = findViewById<Button>(R.id.btnTicket)

        boton.setOnClickListener {
            // Lee los dos EditText como texto.
            // Conviértelos de forma segura y valida sus valores.
            var precioTransformado = precio.text.toString().toDoubleOrNull()
            var cantidadTransformada = cantidad.text.toString().toDoubleOrNull()
            // Calcula y muestra el importe.
            if ((precioTransformado != null) && (cantidadTransformada != null)) {
                var costeCompra = precioTransformado * cantidadTransformada
                resultado.text = "Coste total: " + costeCompra + "€."
            } else {
                resultado.text = "Por favor, introduce un número válido."
            }
        }
    }
}