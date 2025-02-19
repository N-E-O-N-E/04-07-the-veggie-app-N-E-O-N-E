package de.syntax_institut.theveggieapp.data.repositorie

import de.syntax_institut.theveggieapp.data.local.PLACEHOLDER_VEGGIE_MEALS
import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import de.syntax_institut.theveggieapp.data.remote.APIService

class VeggieMealsRepoTest(apiService: APIService) : VeggieMealsRepositoryInterface {
    override val api = apiService

    override suspend fun getVeggieMeals(): VeggieMealsResponse {
        return VeggieMealsResponse(PLACEHOLDER_VEGGIE_MEALS)
    }
}