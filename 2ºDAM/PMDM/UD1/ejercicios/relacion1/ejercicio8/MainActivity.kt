package com.example.pmdmud1.e08

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 1: declara fun saldo y devuelve el cálculo.
    fun saldo(ingresos: Double, comida: Double, transporte: Double): Double {
        return ingresos - comida - transporte
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ingresos = findViewById<EditText>(R.id.etIngresos)
        val comida = findViewById<EditText>(R.id.etComida)
        val transporte = findViewById<EditText>(R.id.etTransporte)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val calcular = findViewById<Button>(R.id.btnCalcular)
        calcular.setOnClickListener {
            // 2: convierte las tres entradas y comprueba los errores.
            val ingresosConv: String = nombre.text.toString().trim()
            val comidaConv: String = ciudad.text.toString().trim()
            val transporteConv: String = nombre.text.toString().trim()
            // TODO 3: llama a saldo y clasifica su valor mediante when.
            resultado.text = saldo(ingresos, comida, transporte)
            // TODO 4: muestra el resultado.
        }
        // TODO 5: crea btnLimpiar en XML y programa su listener.
    }
}
