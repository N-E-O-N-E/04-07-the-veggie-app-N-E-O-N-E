package de.syntax_institut.theveggieapp.ui.app

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.theveggieapp.data.viewModel.VeggieViewModel
import de.syntax_institut.theveggieapp.navigation.BottomNavigationBar
import de.syntax_institut.theveggieapp.navigation.FavoritesScreenRoute
import de.syntax_institut.theveggieapp.navigation.NavigationItem
import de.syntax_institut.theveggieapp.navigation.VeggieScreenRoute
import de.syntax_institut.theveggieapp.ui.screens.FavoritesScreen
import de.syntax_institut.theveggieapp.ui.screens.VeggieScreen
import org.koin.androidx.compose.koinViewModel

/**
 * Die Haupt-Composable-Funktion der App, welche das Grundlayout und die Navigation der Anwendung definiert.
 *
 * Die Funktion verwendet ein Scaffold, um einen einheitlichen Aufbau mit einem TopAppBar, einem
 * NavHost-basierten Content-Bereich und einer BottomNavigationBar bereitzustellen. Es wird zwischen
 * zwei Routen navigiert: einer Liste der vegetarischen Mahlzeiten ([VeggieScreen]) und einer Liste der
 * Favoriten ([FavoritesScreen]). Die Navigation erfolgt über einen [NavController] und einen lokal
 * verwalteten Zustand ([selectedNavigationItem]).
 *
 * Im TopAppBar wird der Titel der App sowie die Anzahl der verfügbaren Mahlzeiten angezeigt. Zudem
 * gibt es einen Refresh-Button, der beim Anklicken die Neuladung der Mahlzeiten über den ViewModel-Callback
 * [viewModel.getVeggieMeals] triggert.
 *
 * Die Funktion beobachtet den Zustand der vegetarischen Mahlzeiten ([veggieMeals]) und der Favoriten
 * ([favoriteMeals]) aus dem [VeggieViewModel].
 *
 * @param viewModel Das [VeggieViewModel], das den Zustand der App (z. B. die Listen der Mahlzeiten und Favoriten)
 *                  bereitstellt und Logik wie das Abrufen und Aktualisieren der Daten handhabt. Standardmäßig wird
 *                  über Koin eine Instanz abgerufen.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheVeggieApp(
    viewModel: VeggieViewModel = koinViewModel()
) {
    val veggieMeals by viewModel.veggieMealsState.collectAsState()
    val favoriteMeals by viewModel.getAllFavoriteMeals().collectAsState()
    val navController = rememberNavController()
    var selectedNavigationItem by rememberSaveable { mutableStateOf(NavigationItem.VeggieList) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("The Dessert App")
                        Spacer(Modifier.weight(1f))
                        Text("(${veggieMeals.size} Gerichte)", fontSize = 13.sp, modifier = Modifier.testTag("mealsText"))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.getVeggieMeals()
                    }, modifier = Modifier.testTag("refreshButton")) {
                        Icon(Icons.Default.Refresh, Icons.Default.Refresh.name)
                    }
                }
            )
        },
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = selectedNavigationItem.route
            ) {
                composable<VeggieScreenRoute> {
                    VeggieScreen(
                        veggieVeggieMeals = veggieMeals,
                        markVeggieMealAsFavorite = { veggieMeal ->
                            viewModel.markVeggieMealAsFavorite(veggieMeal)
                        },
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()

                    )
                }
                composable<FavoritesScreenRoute> {
                    FavoritesScreen(
                        favoriteVeggieMeals = favoriteMeals,
                        removeFavoriteMeal = { favoriteMeal ->
                            viewModel.removeFavoriteMeal(favoriteMeal)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navItems = NavigationItem.entries,
                onNavItemSelection = {
                    selectedNavigationItem = it
                },
                selectedNavItem = selectedNavigationItem,
                favoritesCount = favoriteMeals.size
            )
        }
    )
}

