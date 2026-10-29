package com.example.relacion2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private fun importeBase(precio: Double, cantidad: Int): Double {
        return precio * cantidad
    }

    private fun recargoFinSemana(base: Double, finSemana: Boolean): Double {
        return if (finSemana) base * 0.20 else 0.0
    }

    private fun euros(importe: Double): String {
        return String.format(Locale("es", "ES"), "%.2f €", importe)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val rgEntrada = findViewById<RadioGroup>(R.id.rgEntrada)
        val cbFinSemana = findViewById<CheckBox>(R.id.cbFinSemana)
        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val tvPlazas = findViewById<TextView>(R.id.tvPlazas)
        var plazasDisponibles = 20

        findViewById<Button>(R.id.btnReservar).setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val cantidad = etCantidad.text.toString().toIntOrNull()
            val codigo = etCodigo.text.toString().trim().uppercase()
            val tipoSeleccionado = rgEntrada.checkedRadioButtonId

            if (nombre.isEmpty()) {
                tvResumen.text = "Indica el nombre de la reserva."
            } else if (cantidad == null || cantidad !in 1..8) {
                tvResumen.text = "Introduce entre 1 y 8 entradas."
            } else if (tipoSeleccionado != R.id.rbGeneral && tipoSeleccionado != R.id.rbVip) {
                tvResumen.text = "Selecciona General o VIP."
            } else if (codigo.isNotEmpty() && codigo != "DAM10") {
                tvResumen.text = "Código promocional no reconocido."
            } else if (codigo == "DAM10" && cantidad < 3) {
                tvResumen.text = "DAM10 exige 3 o más entradas."
            } else if (cantidad > plazasDisponibles) {
                tvResumen.text = "Aforo insuficiente: quedan $plazasDisponibles plazas."
            } else {
                val esVip = tipoSeleccionado == R.id.rbVip
                val tipo = if (esVip) "VIP" else "General"
                val precio = if (esVip) 32.0 else 18.0
                val base = importeBase(precio, cantidad)
                val recargo = recargoFinSemana(base, cbFinSemana.isChecked)
                val antesDescuento = base + recargo
                val descuento = if (codigo == "DAM10") antesDescuento * 0.10 else 0.0
                val total = antesDescuento - descuento

                plazasDisponibles -= cantidad
                tvPlazas.text = "Plazas disponibles: $plazasDisponibles"
                tvResumen.text = "Reserva de $nombre\n" +
                    "Tipo: $tipo | Cantidad: $cantidad\n" +
                    "Base: ${euros(base)}\n" +
                    "Recargo: ${euros(recargo)}\n" +
                    "Descuento: -${euros(descuento)}\n" +
                    "TOTAL: ${euros(total)}\n" +
                    "Plazas restantes: $plazasDisponibles"
            }
        }

        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            etNombre.setText("")
            etCantidad.setText("")
            etCodigo.setText("")
            rgEntrada.clearCheck()
            cbFinSemana.isChecked = false
            tvResumen.text = "Todavía no hay reservas en pantalla."
            // No cambia plazasDisponibles: limpiar no cancela una reserva.
        }
    }
}
