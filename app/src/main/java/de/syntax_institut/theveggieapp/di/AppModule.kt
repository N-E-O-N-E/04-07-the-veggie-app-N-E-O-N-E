package de.syntax_institut.theveggieapp.di

import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.local.FavoritesDatabase
import de.syntax_institut.theveggieapp.data.remote.VeggieMealAPI
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsInterface
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsRepository
import de.syntax_institut.theveggieapp.data.repositorie.FavoriteMealsRepositoryInterface
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepository
import de.syntax_institut.theveggieapp.data.viewModel.VeggieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

// Erzwingt eine vollständige Initialisierung da Konstruktor-Injektion
// Klare Abhängigkeiten, notwendige Dependencies sind direkt sichtbar

val appModule = module {

    single {
        FavoritesDatabase.getDatabase(androidContext())
    }

    single {
        get<FavoritesDatabase>().dao()
    }

    factory {
        VeggieMealAPI.retrofitService
    }

    single<FavoriteMealsInterface> {
        VeggieMealsRepository(
            VeggieMealAPI.retrofitService,
            get<FavoritesDao>()
        )
    }

    single<FavoriteMealsRepositoryInterface> {
        FavoriteMealsRepository(
            get<FavoritesDao>()
        )
    }

    viewModelOf(::VeggieViewModel)
}