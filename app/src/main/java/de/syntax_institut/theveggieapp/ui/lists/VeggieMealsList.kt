package de.syntax_institut.theveggieapp.ui.lists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.syntax_institut.theveggieapp.data.local.PLACEHOLDER_VEGGIE_MEALS
import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.ui.components.VeggieMealCard
import de.syntax_institut.theveggieapp.ui.theme.TheVeggieAppTheme

/**
 * Stellt eine Liste von vegetarischen Mahlzeiten dar.
 *
 * Diese Composable-Funktion nutzt eine [LazyColumn], um eine Liste von [VeggieMeal]-Objekten anzuzeigen.
 * Für jede Mahlzeit wird ein [VeggieMealCard] gerendert, welches über den [markVeggieMealAsFavorite]-Callback
 * die Möglichkeit bietet, eine Mahlzeit als Favorit zu markieren.
 *
 * @param veggieMeals Eine Liste von [VeggieMeal]-Objekten, die angezeigt werden sollen.
 * @param modifier Ein [Modifier] zur Anpassung des Layouts der Liste.
 * @param markVeggieMealAsFavorite Callback-Funktion, die ausgeführt wird, wenn eine Mahlzeit als Favorit markiert wird.
 */

@Composable
fun VeggieMealsList(
    veggieMeals: List<VeggieMeal>,
    modifier: Modifier = Modifier,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(veggieMeals) { veggieMeal ->
            VeggieMealCard(veggieMeal = veggieMeal) {
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