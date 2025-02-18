package de.syntax_institut.theveggieapp.data.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.local.FavoritesDatabase
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.data.remote.VeggieMealAPI
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsInterface
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsRepository
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsRepositoryInterface
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepository
import de.syntax_institut.theveggieapp.di.appModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.dsl.module

class VeggieViewModel(
    application: Application,
    private var favoriteMealsRepository: FavoriteMealsRepositoryInterface,
    private var veggieMealsRepository: FavoriteMealsInterface

) : AndroidViewModel(application) {
    private val _veggieMealsState = MutableStateFlow<List<VeggieMeal>>(listOf())
    val veggieMealsState = _veggieMealsState.asStateFlow()

    init {
        getVeggieMeals()
    }

    fun getVeggieMeals() {
        viewModelScope.launch {
            try {
                val veggieMealsResponse = veggieMealsRepository.getVeggieMeals()
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
                val isFavorite = favoriteMealsRepository.isFavInMeal(veggieMeal.idMeal.toInt())

                if (isFavorite == 0) {
                    Log.d("ids", "${favoriteMeal.idMeal}, ${favoriteMeal.initId}")
                    favoriteMealsRepository.insertFavoriteMeal(favoriteMeal = favoriteMeal)
                } else {
                    favoriteMealsRepository.deleteMeal(favoriteMeal)
                }

            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to insert favorite meal ${e.localizedMessage}")
            }
        }
    }

    fun getAllFavoriteMeals(): StateFlow<List<FavoriteMeal>> {
        return favoriteMealsRepository.getFavoriteMeals().stateIn(
            initialValue = listOf(),
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed()
        )
    }

    fun removeFavoriteMeal(favoriteMeal: FavoriteMeal) {
        viewModelScope.launch {
            try {
                favoriteMealsRepository.deleteMeal(favoriteMeal)
            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to delete favorite meal ${e.localizedMessage}")
            }
        }
    }

    private fun convertVeggieMealToFavoriteMeal(veggieMeal: VeggieMeal): FavoriteMeal {
        return FavoriteMeal(
            mealName = veggieMeal.strMeal,
            mealImageURL = veggieMeal.strMealThumb,
            initId = veggieMeal.idMeal
        )
    }
}