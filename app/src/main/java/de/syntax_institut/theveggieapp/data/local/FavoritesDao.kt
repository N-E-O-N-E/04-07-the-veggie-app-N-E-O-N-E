package de.syntax_institut.theveggieapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {
    @Query("SELECT COUNT(*) FROM favorite_meals WHERE initId = :idMeal")
    suspend fun isFavInMeal(idMeal: Int): Int

    @Query("SELECT * FROM favorite_meals")
    fun getAllFavouriteMeals(): Flow<List<FavoriteMeal>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)

    @Update
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)

    @Query("DELETE FROM favorite_meals")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)
}