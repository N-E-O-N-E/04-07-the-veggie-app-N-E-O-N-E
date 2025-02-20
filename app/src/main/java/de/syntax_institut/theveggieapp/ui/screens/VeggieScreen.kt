package de.syntax_institut.theveggieapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.ui.lists.VeggieMealsList

/**
 * Zeigt einen Screen an, der eine Liste vegetarischer Mahlzeiten darstellt.
 *
 * Diese Composable Funktion verwendet einen Box-Container, um die Liste der vegetarischen Gerichte
 * mittels [VeggieMealsList] anzuzeigen. Wird ein Gericht ausgewählt, so wird die Callback-Funktion
 * [markVeggieMealAsFavorite] aufgerufen, um das entsprechende Gericht als Favorit zu markieren.
 *
 * @param modifier Ein [Modifier] zur Anpassung des Layouts und der Darstellung des Screens.
 * @param veggieVeggieMeals Eine Liste von [VeggieMeal]-Objekten, die angezeigt werden sollen.
 * @param markVeggieMealAsFavorite Callback-Funktion, die ausgeführt wird, wenn ein [VeggieMeal] als Favorit markiert wird.
 */

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