package com.example.ventiapplubjulio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button=findViewById(R.id.btnLogin)
        val btnAddTemperature: Button = findViewById(R.id.btnAddTemperature)
        val btnEditTemperature: Button = findViewById(R.id.btnEditTemperature)
        val btnViewHistory: Button = findViewById(R.id.btnViewHistory)

        btnLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de agregar temperatura
        btnAddTemperature.setOnClickListener {
            val intent = Intent(this, AddTemperatureActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de editar temperatura
        btnEditTemperature.setOnClickListener {
            val intent = Intent(this, EditTemperatureActivity::class.java)
            startActivity(intent)
        }

        // Navegar a la pantalla de historial
        btnViewHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
