package de.syntax_institut.theveggieapp.data.models

/**
 * Datenklasse, die eine vegetarische Mahlzeit repräsentiert.
 *
 * Diese Klasse enthält die grundlegenden Informationen zu einer Mahlzeit, wie die eindeutige ID,
 * den Namen der Mahlzeit und eine URL zu einem Vorschaubild.
 *
 * @property idMeal Eindeutige Kennung der Mahlzeit.
 * @property strMeal Der Name der Mahlzeit.
 * @property strMealThumb URL zu einem Vorschaubild der Mahlzeit.
 */

data class VeggieMeal(
    val idMeal: String = "",
    val strMeal: String = "",
    val strMealThumb: String = ""
)