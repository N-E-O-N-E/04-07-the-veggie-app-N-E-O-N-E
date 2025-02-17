package de.syntax_institut.theveggieapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.syntax_institut.theveggieapp.ui.theme.TheVeggieAppTheme

@Composable
fun VeggieMealsList(
    veggieMeals: List<VeggieMeal>,
    modifier: Modifier = Modifier,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(veggieMeals) { veggieMeal ->
            VeggieMealCard(veggieMeal = veggieMeal){
                markVeggieMealAsFavorite(veggieMeal)
            }
        }
    }
}

@Preview
@Composable
fun VeggieMealsListPreview() {
    TheVeggieAppTheme {
        VeggieMealsList(
            veggieMeals = PLACEHOLDER_VEGGIE_MEALS
        ) {}
    }
}