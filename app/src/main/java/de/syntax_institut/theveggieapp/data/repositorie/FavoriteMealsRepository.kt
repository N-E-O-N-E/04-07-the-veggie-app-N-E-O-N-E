package de.syntax_institut.theveggieapp.data.repositorie

import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import kotlinx.coroutines.flow.Flow

interface FavoriteMealsRepositoryInterface {

    fun getFavoriteMeals(): Flow<List<FavoriteMeal>>
    suspend fun isFavInMeal(idMeal: Int): Int
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)
}

class FavoriteMealsRepository(
    private val dao: FavoritesDao
) : FavoriteMealsRepositoryInterface {

    override fun getFavoriteMeals(): Flow<List<FavoriteMeal>> {
        return dao.getAllFavouriteMeals()
    }

    override suspend fun isFavInMeal(idMeal: Int): Int {
        return dao.isFavInMeal(idMeal)
    }

    override suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal) {
        dao.insertFavoriteMeal(favoriteMeal)
    }

    override suspend fun deleteMeal(favoriteMeal: FavoriteMeal) {
        dao.deleteMeal(favoriteMeal)
    }

    override suspend fun updateMeal(favoriteMeal: FavoriteMeal) {
        dao.updateMeal(favoriteMeal)
    }

}