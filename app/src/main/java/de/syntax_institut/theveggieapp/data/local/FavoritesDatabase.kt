package de.syntax_institut.theveggieapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
/**
 * Repräsentiert die Room-Datenbank für die Speicherung von Favoriten-Mahlzeiten.
 * Enthält die Datenbank-Entitäten und den Zugriff auf das zugehörige [FavoritesDao].
 */
@Database(entities = [FavoriteMeal::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {

    /**
     * Liefert das [FavoritesDao], über das Datenbankoperationen ausgeführt werden.
     */
    abstract fun dao(): FavoritesDao

    companion object {
        @Volatile
        private var instance: FavoritesDatabase? = null

        /**
         * Stellt eine Singleton-Instanz der [FavoritesDatabase] bereit.
         * Bei Bedarf wird eine neue Instanz erzeugt, ansonsten die bestehende genutzt.
         *
         * @param context Der Context, der für den Aufbau der Datenbank benötigt wird.
         * @return Eine Singleton-Instanz der [FavoritesDatabase].
         */
        fun getDatabase(context: Context): FavoritesDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    FavoritesDatabase::class.java,
                    "favorite_meals_db"
                ).build().also { instance = it }
            }
        }
    }
}
