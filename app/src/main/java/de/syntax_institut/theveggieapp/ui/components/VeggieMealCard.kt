package de.syntax_institut.theveggieapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import de.syntax_institut.theveggieapp.data.local.PLACEHOLDER_VEGGIE_MEALS
import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.helper.StringHelper.shortenText
import de.syntax_institut.theveggieapp.ui.theme.TheVeggieAppTheme

/**
 * Stellt eine Karte dar, die Informationen zu einer vegetarischen Mahlzeit anzeigt.
 *
 * Die Karte zeigt ein Bild der Mahlzeit, den gekürzten Namen der Mahlzeit sowie einen Button zum
 * Hinzufügen der Mahlzeit als Favorit. Beim Klick auf den Button wird der [markVeggieMealAsFavorite]-Callback ausgelöst.
 *
 * @param modifier Ein [Modifier] zur Anpassung des Layouts der Karte.
 * @param veggieMeal Ein [VeggieMeal]-Objekt, das die Daten der Mahlzeit enthält.
 * @param markVeggieMealAsFavorite Callback-Funktion, die ausgeführt wird, wenn die Mahlzeit als Favorit markiert werden soll.
 */

@Composable
fun VeggieMealCard(
    modifier: Modifier = Modifier,
    veggieMeal: VeggieMeal,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit,
) {

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = veggieMeal.strMealThumb,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = shortenText(veggieMeal.strMeal),
                //text = veggieMeal.strMeal.shortText(),
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f)
            )
            Spacer(Modifier.width(8.dp))
            IconButton(modifier = Modifier.testTag("addFavButton"),
                onClick = {
                    markVeggieMealAsFavorite(veggieMeal)
                }) {
                Icon(Icons.Default.AddCircle, Icons.Default.AddCircle.name)
            }
        }
    }
}

@Preview
@Composable
private fun MealCardPreview() {
    TheVeggieAppTheme {
        val placeholderMeal = PLACEHOLDER_VEGGIE_MEALS.first()
        VeggieMealCard(veggieMeal = placeholderMeal) {}
    }
}