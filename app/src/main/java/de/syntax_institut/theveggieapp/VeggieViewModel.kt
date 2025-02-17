package de.syntax_institut.theveggieapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VeggieViewModel(application: Application) : AndroidViewModel(application) {
    private val api = VeggieMealAPI.retrofitService
    private val database = FavoritesDatabase.getDatabase(application.applicationContext)
    private val dao = database.dao()

    private val _veggieMealsState = MutableStateFlow<List<VeggieMeal>>(listOf())
    val veggieMealsState = _veggieMealsState.asStateFlow()

    init {
        getVeggieMeals()
    }

    fun getVeggieMeals() {
        viewModelScope.launch {
            try {
                val veggieMealsResponse = api.getVeggieMeals()
                _veggieMealsState.value = veggieMealsResponse.meals.shuffled()
            } catch (e: Exception) {
                Log.e("ERROR", "Error getting veggie meals ${e.localizedMessage}")
            }
        }
    }

    fun markVeggieMealAsFavorite(veggieMeal: VeggieMeal) {
        viewModelScope.launch {
            try {
                val favoriteMeal = convertVeggieMealToFavoriteMeal(veggieMeal)
                dao.insertFavoriteMeal(favoriteMeal = favoriteMeal)
            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to insert favorite meal ${e.localizedMessage}")
            }
        }
    }

    fun getAllFavoriteMeals(): StateFlow<List<FavoriteMeal>> {
        return dao.getAllVeggieMeals().stateIn(
            initialValue = listOf(),
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed()
        )
    }

    fun removeFavoriteMeal(favoriteMeal: FavoriteMeal) {
        viewModelScope.launch {
            try {
                dao.deleteMeal(favoriteMeal)
            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to delete favorite meal ${e.localizedMessage}")
            }
        }
    }

    private fun convertVeggieMealToFavoriteMeal(veggieMeal: VeggieMeal): FavoriteMeal {
        return FavoriteMeal(
            mealName = veggieMeal.strMeal,
            mealImageURL = veggieMeal.strMealThumb
        )
    }
}