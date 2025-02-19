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
