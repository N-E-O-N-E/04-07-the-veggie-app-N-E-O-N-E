package de.syntax_institut.theveggieapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Definiert die möglichen Navigationspunkte der App.
 *
 * Jeder Eintrag in der Enumeration [NavigationItem] repräsentiert einen Navigationspunkt, der aus:
 * - einer Route, die den Ziel-Screen identifiziert (vom Typ [Any], hier als [VeggieScreenRoute] oder [FavoritesScreenRoute]),
 * - einem textlichen Label und
 * - einem Icon (vom Typ [ImageVector]) besteht.
 *
 * Diese Navigationselemente werden beispielsweise in der BottomNavigationBar verwendet, um zwischen
 * dem Screen der vegetarischen Mahlzeiten und dem Screen der Favoriten zu wechseln.
 *
 * @property route Die Navigationsroute, welche den Ziel-Screen definiert.
 * @property label Das anzuzeigende Label des Navigationselements.
 * @property icon Das anzuzeigende Icon, welches den Navigationseintrag visuell repräsentiert.
 */

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