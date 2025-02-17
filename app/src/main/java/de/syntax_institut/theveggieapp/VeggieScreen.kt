package de.syntax_institut.theveggieapp

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun VeggieScreen(
    modifier: Modifier = Modifier,
    veggieVeggieMeals: List<VeggieMeal>,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit
) {
    Box(modifier = modifier) {
        VeggieMealsList(veggieVeggieMeals) { meal ->
            markVeggieMealAsFavorite(meal)
        }
    }
}