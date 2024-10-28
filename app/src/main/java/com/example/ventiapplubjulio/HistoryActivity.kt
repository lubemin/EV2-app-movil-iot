package com.example.ventiapplubjulio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val btnBackToMain: Button = findViewById(R.id.btnBackToMain)
        val tvTemperatureHistory: TextView = findViewById(R.id.tvHistory)

        // Cargar y mostrar el historial de temperaturas
        loadTemperatureHistory(tvTemperatureHistory)

        // Botón para volver a la pantalla principal
        btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Método para cargar el historial de temperaturas de TemperatureStorage
    private fun loadTemperatureHistory(textView: TextView) {
        val temperatures = TemperatureStorage.getAllTemperatures()

        if (temperatures.isEmpty()) {
            textView.text = "No hay temperaturas registradas"
        } else {
            // Mostrar las temperaturas en el TextView
            textView.text = temperatures.joinToString(separator = "\n") // Mostrar cada temperatura en una nueva línea
        }
    }
}