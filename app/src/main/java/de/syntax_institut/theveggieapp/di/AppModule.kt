package de.syntax_institut.theveggieapp.di

import FavoriteMealsRepository
import FavoriteMealsRepositoryInterface
import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.local.FavoritesDatabase
import de.syntax_institut.theveggieapp.data.remote.VeggieMealAPI
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepoTest
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepository
import de.syntax_institut.theveggieapp.data.repositorie.VeggieMealsRepositoryInterface
import de.syntax_institut.theveggieapp.data.viewModel.VeggieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Koin-Modul für die Dependency Injection in der App.
 *
 * Dieses Modul definiert die Bereitstellung von Singleton-Instanzen und ViewModels, die in der App verwendet werden:
 *
 * - Es wird eine Singleton-Instanz von [FavoritesDatabase] erstellt, welche die lokale Datenbank repräsentiert.
 * - Über die Datenbankinstanz wird ein [FavoritesDao] als Singleton bereitgestellt, um Datenbankoperationen auszuführen.
 * - Die Retrofit-Service-Instanz von [VeggieMealAPI] wird als Singleton eingebunden, um Netzwerkaufrufe zu ermöglichen.
 * - Ein Singleton der Implementierung von [VeggieMealsRepositoryInterface] (hier [VeggieMealsRepository]) wird registriert,
 *   um den Zugriff auf vegetarische Mahlzeiten zu kapseln. (Alternativ kann die Testimplementierung [VeggieMealsRepoTest] genutzt werden.)
 * - Ebenso wird ein Singleton für [FavoriteMealsRepositoryInterface] (konkret [FavoriteMealsRepository]) erstellt,
 *   um die Verwaltung der Favoriten zu realisieren.
 * - Abschließend wird das [VeggieViewModel] als ViewModel instanziiert und bereitgestellt.
 */

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