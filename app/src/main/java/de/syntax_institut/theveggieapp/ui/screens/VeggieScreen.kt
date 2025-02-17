package de.syntax_institut.theveggieapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.ui.lists.VeggieMealsList

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