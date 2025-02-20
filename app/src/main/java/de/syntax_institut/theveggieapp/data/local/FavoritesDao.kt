package de.syntax_institut.theveggieapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) für die Verwaltung von Favoriten-Mahlzeiten.
 */
@Dao
interface FavoritesDao {

    /**
     * Prüft, ob eine bestimmte Mahlzeit in den Favoriten vorhanden ist.
     *
     * @param idMeal Die eindeutige ID der zu prüfenden Mahlzeit.
     * @return Die Anzahl, wie oft diese Mahlzeit in den Favoriten vorkommt.
     *         Normalerweise `1`, wenn sie vorhanden ist, sonst `0`.
     */
    @Query("SELECT COUNT(*) FROM favorite_meals WHERE initId = :idMeal")
    suspend fun isFavInMeal(idMeal: Int): Int

    /**
     * Liefert alle favorisierten Mahlzeiten als [Flow], um auf Änderungen reagieren zu können.
     *
     * @return Ein [Flow], das bei jeder Datenänderung eine aktuelle Liste von [FavoriteMeal] ausgibt.
     */
    @Query("SELECT * FROM favorite_meals")
    fun getAllFavouriteMeals(): Flow<List<FavoriteMeal>>

    /**
     * Fügt eine neue favorisierte Mahlzeit in die Datenbank ein.
     *
     * @param favoriteMeal Das hinzuzufügende [FavoriteMeal]-Objekt.
     *
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Aktualisiert die Daten einer bereits vorhandenen favorisierten Mahlzeit.
     *
     * @param favoriteMeal Das zu aktualisierende [FavoriteMeal]-Objekt.
     */
    @Update
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)

    /**
     * Entfernt alle Einträge aus der Favoriten-Tabelle.
     */
    @Query("DELETE FROM favorite_meals")
    suspend fun deleteAll()

    /**
     * Löscht eine spezifische favorisierte Mahlzeit aus der Datenbank.
     *
     * @param favoriteMeal Das zu entfernende [FavoriteMeal]-Objekt.
     */
    @Delete
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)
}
