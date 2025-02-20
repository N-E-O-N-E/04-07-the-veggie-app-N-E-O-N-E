package de.syntax_institut.theveggieapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * Custom Application-Klasse der App.
 *
 * Diese Klasse wird beim Start der Anwendung instanziiert und initialisiert das Koin-Framework
 * für Dependency Injection. Im [onCreate]-Aufruf wird Koin mit dem Android-Kontext der App konfiguriert
 * und das Dependency Injection Modul [appModule] geladen, welches alle notwendigen Abhängigkeiten bereitstellt.
 */

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }

    }
}