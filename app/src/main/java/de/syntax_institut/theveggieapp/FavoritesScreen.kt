package de.syntax_institut.theveggieapp

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


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