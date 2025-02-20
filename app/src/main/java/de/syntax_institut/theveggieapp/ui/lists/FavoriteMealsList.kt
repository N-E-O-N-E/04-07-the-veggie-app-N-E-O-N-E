package de.syntax_institut.theveggieapp.ui.lists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.syntax_institut.theveggieapp.data.local.PLACEHOLDER_FAVORITE_MEALS
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import de.syntax_institut.theveggieapp.ui.components.FavoriteMealCard
import de.syntax_institut.theveggieapp.ui.theme.TheVeggieAppTheme

/**
 * Stellt eine Liste der Favoriten (vegetarische Mahlzeiten) dar.
 *
 * Diese Composable-Funktion verwendet eine [LazyColumn], um die übergebene Liste von [FavoriteMeal]-Objekten anzuzeigen.
 * Für jede Mahlzeit wird ein [FavoriteMealCard] gerendert, das über den [deleteFavoriteMeal]-Callback die Möglichkeit bietet,
 * den Favoriten aus der Liste zu entfernen.
 *
 * @param favoriteMeals Eine Liste von [FavoriteMeal]-Objekten, die als Favoriten angezeigt werden sollen.
 * @param modifier Ein [Modifier] zur Anpassung des Layouts der Liste.
 * @param deleteFavoriteMeal Callback-Funktion, die ausgeführt wird, wenn ein Favorit entfernt werden soll.
 */

@Composable
fun FavoriteMealsList(
    favoriteMeals: List<FavoriteMeal>,
    modifier: Modifier = Modifier,
    deleteFavoriteMeal: (FavoriteMeal) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(favoriteMeals) { favoriteMeal ->
            FavoriteMealCard(favoriteMeal = favoriteMeal) {
                deleteFavoriteMeal(favoriteMeal)
            }
        }
    }
}

@Preview
@Composable
fun FavoritesListPreview() {
    TheVeggieAppTheme {
        FavoriteMealsList(
            favoriteMeals = PLACEHOLDER_FAVORITE_MEALS
        ) {}
    }
}