package de.syntax_institut.theveggieapp.data.repositorie

import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import de.syntax_institut.theveggieapp.data.remote.APIService

/**
 * Interface zur Definition der Repository-Funktionalitäten für den Abruf von vegetarischen Mahlzeiten.
 *
 * Dieses Interface stellt den Vertrag bereit, den sowohl die Produktions- als auch die Testimplementierung erfüllen.
 * Es definiert einen API-Service-Zugriff über die Property [api] und eine suspend-Funktion [getVeggieMeals], die
 * eine [VeggieMealsResponse] zurückgibt.
 */

interface VeggieMealsRepositoryInterface {
    val api: APIService
    suspend fun getVeggieMeals(): VeggieMealsResponse
}

class VeggieMealsRepository(apiService: APIService): VeggieMealsRepositoryInterface {
    override val api = apiService

    override suspend fun getVeggieMeals(): VeggieMealsResponse {
        return api.getVeggieMeals()
    }
}