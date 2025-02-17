package de.syntax_institut.theveggieapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import de.syntax_institut.theveggieapp.ui.lists.FavoriteMealsList


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