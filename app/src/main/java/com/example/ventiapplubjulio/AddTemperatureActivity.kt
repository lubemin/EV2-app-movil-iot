package com.example.ventiapplubjulio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddTemperatureActivity : AppCompatActivity() {
    private val temperatureList = mutableListOf<TemperatureEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_temperature)

        val btnSubmitTemperature: Button = findViewById(R.id.btnSubmitTemperature)
        val btnBackToMain: Button = findViewById(R.id.btnBackToMain)
        val etNewTemperature: EditText = findViewById(R.id.etTemperature)

        // Funcionalidad del botón de guardar temperatura
        btnSubmitTemperature.setOnClickListener {
            val temperatureText = etNewTemperature.text.toString()
            if (temperatureText.isNotEmpty()) {
                val temperatureValue = temperatureText.toFloat()
                val newEntry = TemperatureEntry(temperatureValue)
                temperatureList.add(newEntry)  // Guardar la nueva entrada en la lista
                etNewTemperature.text.clear()  // Limpiar el campo de entrada
            }
        }

        // Botón para volver a la pantalla principal
        btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}