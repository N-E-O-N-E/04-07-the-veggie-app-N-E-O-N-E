package de.syntax_institut.theveggieapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
) {
    VeggieList(
        route = VeggieScreenRoute,
        label = "Veggie Gerichte",
        icon = Icons.Default.Fastfood
    ),
    Favorites(
        route = FavoritesScreenRoute,
        label = "Favoriten",
        icon = Icons.Default.Favorite
    )
}