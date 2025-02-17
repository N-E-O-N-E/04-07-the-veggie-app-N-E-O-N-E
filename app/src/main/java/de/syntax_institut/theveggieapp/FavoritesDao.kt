package de.syntax_institut.theveggieapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)

    @Update
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)

    @Query("DELETE FROM favorite_meals")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)

    @Query("SELECT * FROM favorite_meals")
    fun getAllVeggieMeals(): Flow<List<FavoriteMeal>>
}