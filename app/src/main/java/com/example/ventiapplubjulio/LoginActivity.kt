package com.example.ventiapplubjulio

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("temperature_data", MODE_PRIVATE)

        // Añadimos la funcionalidad del botón de login
        val btnLoginSubmit: Button = findViewById(R.id.btnLoginSubmit)

        // Cuando se hace clic en el botón de login, se navega a la pantalla principal (MainActivity)
        btnLoginSubmit.setOnClickListener {
            // Aquí puedes agregar cualquier validación de login si es necesario
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Cierra la actividad de login para evitar volver a ella con el botón "Atrás"
        }
    }

    // Método para guardar la temperatura en SharedPreferences
    private fun saveTemperature(temperature: Float) {
        val editor = sharedPreferences.edit()
        val currentTemperatures = sharedPreferences.getString("temperatures", "")
        val newTemperatures = if (currentTemperatures.isNullOrEmpty()) {
            temperature.toString()
        } else {
            "$currentTemperatures,$temperature"
        }
        editor.putString("temperatures", newTemperatures)
        editor.apply()
    }
}
