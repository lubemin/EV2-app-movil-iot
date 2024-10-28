package com.example.ventiapplubjulio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditTemperatureActivity : AppCompatActivity() {
    private lateinit var etNewTemperature: EditText
    private lateinit var tvCurrentTemperature: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_temperature)

        val btnUpdateTemperature: Button = findViewById(R.id.btnUpdateTemperature)
        val btnBackToMain: Button = findViewById(R.id.btnBackToMain)
        etNewTemperature = findViewById(R.id.etNewTemperature)
        tvCurrentTemperature = findViewById(R.id.tvCurrentTemperature)

        // Cargar la temperatura actual al iniciar la actividad
        loadCurrentTemperature()

        // Botón para actualizar la temperatura
        btnUpdateTemperature.setOnClickListener {
            val newTemperatureText = etNewTemperature.text.toString()
            if (newTemperatureText.isNotEmpty()) {
                val newTemperatureValue = newTemperatureText.toFloat()

                // Actualizar la temperatura en TemperatureStorage
                TemperatureStorage.addTemperature(newTemperatureValue)

                // Actualizar la vista con la nueva temperatura
                loadCurrentTemperature()

                // Limpiar el campo de entrada
                etNewTemperature.text.clear()
            }
        }

        // Botón para volver a la pantalla principal
        btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Método para cargar y mostrar la temperatura actual
    private fun loadCurrentTemperature() {
        val currentTemperature = TemperatureStorage.getCurrentTemperature()
        tvCurrentTemperature.text = if (currentTemperature > 0) {
            currentTemperature.toString() // Actualiza el TextView con la temperatura actual
        } else {
            "No hay temperatura registrada" // Mensaje si no hay temperatura
        }
    }
}
