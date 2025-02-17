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