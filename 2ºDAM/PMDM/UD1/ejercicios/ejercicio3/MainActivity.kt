package com.example.pmdmud1.e03

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
        val edad = findViewById<EditText>(R.id.etEdad)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val boton = findViewById<Button>(R.id.btnComprobar)

        boton.setOnClickListener {
            // Convierte edad con toIntOrNull().
            var edadConv: Int? = edad.text.toString().toIntOrNull()
            // Valida null y los límites 0..120.
            if (edadConv == null || edadConv <= 0 || edadConv >= 120) {
                resultado.text = "Edad no válida."
            } else {
                // Distingue menor de 18, permitido y mayor de 65.
                when {
                    edadConv < 18 -> resultado.text = "No puede entrar: menor de edad."
                    edadConv > 65 -> resultado.text = "No puede entrar: supera edad máxima."
                    else -> resultado.text = "Acceso permitido."
                }
            }
        }
    }
}
