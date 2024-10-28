package com.example.ventiapplubjulio

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("temperature_data", MODE_PRIVATE)

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

    // Método para cargar el historial de temperaturas de SharedPreferences
    private fun loadTemperatureHistory(textView: TextView) {
        val temperatures = sharedPreferences.getString("temperatures", "")
        if (temperatures.isNullOrEmpty()) {
            textView.text = "no hay temperaturas registradas"
        } else {
            // Mostrar las temperaturas en el TextView
            textView.text = temperatures.replace(",", "\n") // Reemplaza las comas por saltos de línea
        }
    }
}
