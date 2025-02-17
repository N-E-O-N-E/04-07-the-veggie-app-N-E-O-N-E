package de.syntax_institut.theveggieapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteMeal::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract fun dao(): FavoritesDao

    companion object {
        @Volatile
        private var instance: FavoritesDatabase? = null

        fun getDatabase(context: Context): FavoritesDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context, FavoritesDatabase::class.java, "favorite_meals_db"
                ).build().also { instance = it }
            }
        }
    }
}