package de.syntax_institut.theveggieapp.data.local

import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal

const val PLACEHOLDER_NAME = "Kartoffelsalat"
const val PLACEHOLDER_URL = "https://www.themealdb.com/images/media/meals/ebvuir1699013665.jpg"

val PLACEHOLDER_VEGGIE_MEALS: List<VeggieMeal> = listOf(
    VeggieMeal(idMeal = "0", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "1", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "2", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "3", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "4", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "5", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "6", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "7", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(idMeal = "8", strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),

)

val PLACEHOLDER_FAVORITE_MEALS = listOf(
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL, initId = "0"),

)