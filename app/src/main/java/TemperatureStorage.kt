package com.example.ventiapplubjulio

object TemperatureStorage {
    // Lista mutable para almacenar las temperaturas
    private val temperatures = mutableListOf<Float>()

    // Método para agregar una nueva temperatura
    fun addTemperature(temperature: Float) {
        temperatures.add(temperature)
    }

    // Método para obtener todas las temperaturas
    fun getAllTemperatures(): List<Float> {
        return temperatures
    }

    // Método para obtener la última temperatura registrada
    fun getCurrentTemperature(): Float {
        return temperatures.lastOrNull() ?: 0.0f // Devuelve la última temperatura o 0.0 si no hay temperaturas
    }

    // Método opcional para limpiar la lista de temperaturas
    fun clearTemperatures() {
        temperatures.clear()
    }
}
