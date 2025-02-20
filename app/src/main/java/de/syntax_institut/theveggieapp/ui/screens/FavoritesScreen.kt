package de.syntax_institut.theveggieapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import de.syntax_institut.theveggieapp.ui.lists.FavoriteMealsList

/**
 * Zeigt einen Screen an, der die Liste der Favoriten (vegetarische Mahlzeiten) darstellt.
 *
 * Diese Composable-Funktion verwendet einen Box-Container, um die übergebene Liste von Favoriten anzuzeigen.
 * Dabei wird die Funktion [FavoriteMealsList] aufgerufen, welche die Liste der Favoriten darstellt und
 * eine Callback-Funktion zum Entfernen eines Favoriten erhält.
 *
 * @param modifier Ein [Modifier] zur Anpassung des Layouts und der Darstellung des Screens.
 * @param favoriteVeggieMeals Eine Liste von [FavoriteMeal]-Objekten, die als Favoriten angezeigt werden.
 * @param removeFavoriteMeal Callback-Funktion, die ausgeführt wird, wenn ein Favorit entfernt werden soll.
 */

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    favoriteVeggieMeals: List<FavoriteMeal>,
    removeFavoriteMeal: (FavoriteMeal) -> Unit
) {
    Box(modifier = modifier) {
        FavoriteMealsList(
            favoriteMeals = favoriteVeggieMeals,
            deleteFavoriteMeal = removeFavoriteMeal
        )
    }
}