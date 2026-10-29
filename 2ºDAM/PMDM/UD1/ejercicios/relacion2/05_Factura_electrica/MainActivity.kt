package com.example.relacion2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private fun costeEnergia(kwh: Double): Double {
        return if (kwh <= 100.0) {
            kwh * 0.12
        } else {
            100.0 * 0.12 + (kwh - 100.0) * 0.18
        }
    }

    private fun conIva(base: Double): Double {
        return base * 1.21
    }

    private fun euros(valor: Double): String {
        return String.format(Locale("es", "ES"), "%.2f €", valor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etKwh = findViewById<EditText>(R.id.etKwh)
        val etDias = findViewById<EditText>(R.id.etDias)
        val cbBonoSocial = findViewById<CheckBox>(R.id.cbBonoSocial)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        findViewById<Button>(R.id.btnCalcular).setOnClickListener {
            val kwh = etKwh.text.toString().replace(',', '.').toDoubleOrNull()
            val dias = etDias.text.toString().toIntOrNull()
            if (kwh == null || !kwh.isFinite() || kwh < 0.0 ||
                dias == null || dias !in 1..31) {
                tvResultado.text = "Consumo o días no válidos."
            } else {
                val fijo = dias * 0.45
                val energia = costeEnergia(kwh)
                val descuento = if (cbBonoSocial.isChecked) energia * 0.25 else 0.0
                val energiaBonificada = energia - descuento
                val base = fijo + energiaBonificada
                val iva = base * 0.21
                val total = conIva(base)
                tvResultado.text = "Consumo: $kwh kWh ($dias días)\n" +
                    "Término fijo: ${euros(fijo)}\n" +
                    "Energía: ${euros(energia)}\n" +
                    "Bono social: -${euros(descuento)}\n" +
                    "Base imponible: ${euros(base)}\n" +
                    "IVA 21 %: ${euros(iva)}\nTOTAL: ${euros(total)}"
            }
        }

        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            etKwh.setText("")
            etDias.setText("")
            cbBonoSocial.isChecked = false
            tvResultado.text = "Introduce consumo y días."
        }
    }
}
