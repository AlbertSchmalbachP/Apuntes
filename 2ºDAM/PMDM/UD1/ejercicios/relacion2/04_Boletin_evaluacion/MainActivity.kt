package com.example.relacion2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private fun mediaPonderada(b1: Double, b2: Double, b3: Double): Double {
        return b1 * 0.20 + b2 * 0.30 + b3 * 0.50
    }

    private fun mostrarNota(valor: Double): String {
        return String.format(Locale("es", "ES"), "%.2f", valor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etBloque1 = findViewById<EditText>(R.id.etBloque1)
        val etBloque2 = findViewById<EditText>(R.id.etBloque2)
        val etBloque3 = findViewById<EditText>(R.id.etBloque3)
        val tvNota = findViewById<TextView>(R.id.tvNota)
        val tvEstado = findViewById<TextView>(R.id.tvEstado)

        findViewById<Button>(R.id.btnEvaluar).setOnClickListener {
            val b1 = etBloque1.text.toString().replace(',', '.').toDoubleOrNull()
            val b2 = etBloque2.text.toString().replace(',', '.').toDoubleOrNull()
            val b3 = etBloque3.text.toString().replace(',', '.').toDoubleOrNull()
            if (b1 == null || b2 == null || b3 == null ||
                !b1.isFinite() || !b2.isFinite() || !b3.isFinite() ||
                b1 !in 0.0..10.0 || b2 !in 0.0..10.0 || b3 !in 0.0..10.0) {
                tvNota.text = "Notas no válidas."
                tvEstado.text = "Revisa los tres bloques (0-10)."
                tvEstado.setTextColor(getColor(R.color.rojo_error))
            } else {
                val media = mediaPonderada(b1, b2, b3)
                val mediaSuficiente = media >= 5.0
                val minimosSuperados = b1 >= 4.0 && b2 >= 4.0 && b3 >= 4.0
                tvNota.text = "Media ponderada: ${mostrarNota(media)}"
                if (mediaSuficiente && minimosSuperados) {
                    val calificacion = when {
                        media < 7.0 -> "Aprobado"
                        media < 9.0 -> "Notable"
                        else -> "Sobresaliente"
                    }
                    tvEstado.text = "SUPERADA - $calificacion"
                    tvEstado.setTextColor(getColor(R.color.verde_ok))
                } else {
                    val motivo = when {
                        !mediaSuficiente && !minimosSuperados -> "media inferior a 5 y bloque inferior a 4"
                        !mediaSuficiente -> "media inferior a 5"
                        else -> "algún bloque inferior a 4"
                    }
                    tvEstado.text = "NO SUPERADA: $motivo"
                    tvEstado.setTextColor(getColor(R.color.rojo_error))
                }
            }
        }

        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            etBloque1.setText("")
            etBloque2.setText("")
            etBloque3.setText("")
            tvNota.text = "Introduce las tres notas."
            tvEstado.text = ""
            tvEstado.setTextColor(getColor(R.color.texto_principal))
        }
    }
}
