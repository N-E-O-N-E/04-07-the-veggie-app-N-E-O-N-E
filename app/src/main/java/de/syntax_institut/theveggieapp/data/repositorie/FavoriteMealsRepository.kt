import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import de.syntax_institut.theveggieapp.data.models.FavoriteMeal
import kotlinx.coroutines.flow.Flow

/**
 * Schnittstelle für Repository-Funktionalitäten im Zusammenhang mit den favorisierten Mahlzeiten.
 *
 * Dieses Interface definiert die notwendigen Operationen zur Verwaltung der Favoriten in der App, wie z.B.
 * das Abrufen der Favoriten, das Überprüfen, Einfügen, Löschen und Aktualisieren eines favorisierten Gerichts.
 */
interface FavoriteMealsRepositoryInterface {

    /**
     * Gibt einen Flow zurück, der die Liste aller gespeicherten Favoriten repräsentiert.
     *
     * @return Ein [Flow] mit einer Liste von [FavoriteMeal]-Objekten.
     */
    fun getFavoriteMeals(): Flow<List<FavoriteMeal>>

    /**
     * Überprüft, ob ein Gericht mit der gegebenen [idMeal] als Favorit gespeichert ist.
     *
     * @param idMeal Die ID der Mahlzeit.
     * @return Ein [Int]-Wert, der angibt, ob das Gericht als Favorit vorliegt (z.B. 0 für "nicht vorhanden").
     */
    suspend fun isFavInMeal(idMeal: Int): Int

    /**
     * Fügt eine neue favorisierte Mahlzeit in die Datenbank ein.
     *
     * @param favoriteMeal Das [FavoriteMeal]-Objekt, das eingefügt werden soll.
     */
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Löscht eine favorisierte Mahlzeit aus der Datenbank.
     *
     * @param favoriteMeal Das [FavoriteMeal]-Objekt, das entfernt werden soll.
     */
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Aktualisiert eine existierende favorisierte Mahlzeit in der Datenbank.
     *
     * @param favoriteMeal Das [FavoriteMeal]-Objekt mit den aktualisierten Daten.
     */
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)
}

/**
 * Produktionsimplementierung des [FavoriteMealsRepositoryInterface].
 *
 * Diese Klasse kapselt alle Datenbankoperationen in Bezug auf favorisierte Mahlzeiten und verwendet dazu
 * [FavoritesDao]. Sie ermöglicht das Abrufen, Überprüfen, Einfügen, Löschen und Aktualisieren der Favoriten.
 *
 * @param dao Eine Instanz von [FavoritesDao], die den tatsächlichen Datenbankzugriff ermöglicht.
 */
class FavoriteMealsRepository(
    private val dao: FavoritesDao
) : FavoriteMealsRepositoryInterface {

    /**
     * Gibt einen Flow zurück, der alle favorisierten Mahlzeiten aus der Datenbank liefert.
     *
     * @return Ein [Flow] mit einer Liste von [FavoriteMeal]-Objekten.
     */
    override fun getFavoriteMeals(): Flow<List<FavoriteMeal>> {
        return dao.getAllFavouriteMeals()
    }

    /**
     * Überprüft, ob ein Gericht mit der gegebenen [idMeal] als Favorit gespeichert ist.
     *
     * @param idMeal Die ID der Mahlzeit.
     * @return Ein [Int]-Wert, der angibt, ob das Gericht als Favorit existiert (z.B. 0 für "nicht vorhanden").
     */
    override suspend fun isFavInMeal(idMeal: Int): Int {
        return dao.isFavInMeal(idMeal)
    }

    /**
     * Fügt die gegebene favorisierte Mahlzeit in die Datenbank ein.
     *
     * @param favoriteMeal Das [FavoriteMeal]-Objekt, das eingefügt werden soll.
     */
    override suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal) {
        dao.insertFavoriteMeal(favoriteMeal)
    }

    /**
     * Löscht die gegebene favorisierte Mahlzeit aus der Datenbank.
     *
     * @param favoriteMeal Das [FavoriteMeal]-Objekt, das entfernt werden soll.
     */
    override suspend fun deleteMeal(favoriteMeal: FavoriteMeal) {
        dao.deleteMeal(favoriteMeal)
    }

    /**
     * Aktualisiert die gegebene favorisierte Mahlzeit in der Datenbank.
     *
     * @param favoriteMeal Das [FavoriteMeal]-Objekt mit den aktualisierten Daten.
     */
    override suspend fun updateMeal(favoriteMeal: FavoriteMeal) {
        dao.updateMeal(favoriteMeal)
    }
}