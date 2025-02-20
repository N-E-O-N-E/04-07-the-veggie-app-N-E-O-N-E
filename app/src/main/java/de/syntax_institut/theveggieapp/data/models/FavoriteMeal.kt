package de.syntax_institut.theveggieapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Repräsentiert eine favorisierte Mahlzeit in der Datenbank.
 *
 * @property idMeal        Automatisch generierte, eindeutige ID der Mahlzeit.
 * @property initId        Initiale Kennung, die die Mahlzeit eindeutig referenziert.
 * @property mealName      Name der Mahlzeit.
 * @property mealImageURL  URL zum Bild der Mahlzeit.
 */

@Entity(tableName = "favorite_meals")
data class FavoriteMeal(
    @PrimaryKey(autoGenerate = true)
    val idMeal: Int = 0,
    val initId: String,
    val mealName: String = "",
    val mealImageURL: String = ""
)
