package de.syntax_institut.theveggieapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_meals")
data class FavoriteMeal(
    @PrimaryKey(autoGenerate = true)
    val idMeal: Int = 0,
    val initId: String,
    val mealName: String = "",
    val mealImageURL: String = ""
)
