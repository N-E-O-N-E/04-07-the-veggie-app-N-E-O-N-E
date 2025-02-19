package de.syntax_institut.theveggieapp.data.repositorie

import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import de.syntax_institut.theveggieapp.data.remote.APIService

interface FavoriteMealsInterface {
    val api: APIService
    suspend fun getVeggieMeals(): VeggieMealsResponse
}

class VeggieMealsRepository(apiService: APIService): FavoriteMealsInterface {
    override val api = apiService

    override suspend fun getVeggieMeals(): VeggieMealsResponse {
        return api.getVeggieMeals()
    }
}