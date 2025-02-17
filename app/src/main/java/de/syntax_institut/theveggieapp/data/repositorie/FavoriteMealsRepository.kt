package de.syntax_institut.theveggieapp.data.repositorie

import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import kotlinx.coroutines.flow.Flow

interface FavoriteMealsRepositoryInterface {
    val dao: FavoritesDao
    val allFavoriteMeals: Flow<List<FavoriteMeal>>

    suspend fun getAllFavoriteMeals(): Flow<List<FavoriteMeal>>

}


class FavoriteMealsRepository(favDao: FavoritesDao): FavoriteMealsRepositoryInterface {
    override val dao = favDao
    override val allFavoriteMeals: Flow<List<FavoriteMeal>> = dao.getAllVeggieMeals()

    override suspend fun getAllFavoriteMeals(): Flow<List<FavoriteMeal>> {
        return allFavoriteMeals
    }

}