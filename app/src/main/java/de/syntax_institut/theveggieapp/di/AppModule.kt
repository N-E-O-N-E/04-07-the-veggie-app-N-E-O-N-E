package de.syntax_institut.theveggieapp.di

import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.local.FavoritesDatabase
import de.syntax_institut.theveggieapp.data.local.PLACEHOLDER_VEGGIE_MEALS
import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import de.syntax_institut.theveggieapp.data.models.VeggieMeal
import de.syntax_institut.theveggieapp.data.remote.VeggieMealAPI
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepositoryInterface
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsRepository
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsRepositoryInterface
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepoTest
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepository
import de.syntax_institut.theveggieapp.data.viewModel.VeggieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

// Erzwingt eine vollständige Initialisierung da Konstruktor-Injektion
// Klare Abhängigkeiten, notwendige Dependencies sind direkt sichtbar

val appModule = module {

    single<FavoritesDatabase> {
        FavoritesDatabase.getDatabase(androidContext())
    }

    single<FavoritesDao> {
        get<FavoritesDatabase>().dao()
    }

    single {
        VeggieMealAPI.retrofitService
    }

    single<VeggieMealsRepositoryInterface> {
        VeggieMealsRepository(get())
    }

//    single<VeggieMealsRepositoryInterface> {
//        VeggieMealsRepoTest(get())
//    }

    single<FavoriteMealsRepositoryInterface> {
        FavoriteMealsRepository(
            get()
        )
    }

    viewModelOf(::VeggieViewModel)
}