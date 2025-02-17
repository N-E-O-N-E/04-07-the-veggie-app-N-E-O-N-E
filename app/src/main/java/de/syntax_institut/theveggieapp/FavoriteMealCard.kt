package de.syntax_institut.theveggieapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import de.syntax_institut.theveggieapp.ui.theme.TheVeggieAppTheme

@Composable
fun FavoriteMealCard(
    modifier: Modifier = Modifier,
    favoriteMeal: FavoriteMeal,
    markVeggieMealAsFavorite: (FavoriteMeal) -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Column {
            AsyncImage(
                model = favoriteMeal.mealImageURL,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(96.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.width(8.dp))
                Text(
                    text = favoriteMeal.mealName,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(1f)
                )
                Spacer(Modifier.width(8.dp))
                IconButton(onClick = {
                    markVeggieMealAsFavorite(favoriteMeal)
                }) {
                    Icon(Icons.Default.Delete, Icons.Default.Delete.name)
                }
            }
        }

    }
}

@Preview
@Composable
private fun MealCardPreview() {
    TheVeggieAppTheme {
        FavoriteMealCard(favoriteMeal = PLACEHOLDER_FAVORITE_MEALS.first()) {}
    }
}