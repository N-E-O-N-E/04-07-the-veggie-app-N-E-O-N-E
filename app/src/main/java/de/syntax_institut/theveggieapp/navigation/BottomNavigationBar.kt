package de.syntax_institut.theveggieapp.navigation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

/**
 * Stellt die untere Navigationsleiste der App dar.
 *
 * Diese Composable-Funktion rendert eine [NavigationBar] mit den übergebenen Navigationspunkten. Für jeden
 * Navigationspunkt wird ein [NavigationBarItem] erzeugt, das:
 * - einen ausgewählten Zustand basierend auf [selectedNavItem] besitzt,
 * - beim Klick die [onNavItemSelection]-Callback-Funktion aufruft,
 * - ein Icon anzeigt, das in einem [BadgedBox] eingebettet ist, um bei Bedarf (wenn es sich um den Favoriten-Item handelt
 *   und [favoritesCount] größer als 0 ist) einen Badge mit der Anzahl der Favoriten anzuzeigen,
 * - ein Label mit dem Namen des Navigationspunkts darstellt.
 *
 * @param navItems Eine Liste von [NavigationItem], die die möglichen Navigationspunkte repräsentiert.
 * @param onNavItemSelection Callback-Funktion, die aufgerufen wird, wenn ein Navigationspunkt ausgewählt wird.
 * @param selectedNavItem Der aktuell ausgewählte Navigationspunkt.
 * @param favoritesCount Die Anzahl der Favoriten, die als Badge beim Favoriten-Navigationspunkt angezeigt wird.
 */

@Composable
fun BottomNavigationBar(
    navItems: List<NavigationItem>,
    onNavItemSelection: (NavigationItem) -> Unit,
    selectedNavItem: NavigationItem,
    favoritesCount: Int
) {
    NavigationBar {
        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = selectedNavItem == navItem,
                onClick = { onNavItemSelection(navItem) },
                icon = {
                    BadgedBox(badge = {
                            if (navItem == NavigationItem.Favorites && favoritesCount > 0) {
                                Badge {
                                    Text(favoritesCount.toString(), modifier = Modifier.testTag("favBadgedCount"))
                                }
                            }
                        }
                    ) {
                        Icon(navItem.icon, contentDescription = navItem.label)
                    }
                },
                label = { Text(navItem.label) }
            )
        }
    }
}
