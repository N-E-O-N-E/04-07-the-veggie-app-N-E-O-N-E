package de.syntax_institut.theveggieapp.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Die Basis-URL für den Zugriff auf die MealDB API.
 */
const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

/**
 * Konfiguriert Moshi als JSON-Parser mit Unterstützung für Kotlin-spezifische Anpassungen.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Baut eine Retrofit-Instanz, die den Moshi-Converter verwendet und an der Basis-URL konfiguriert ist.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * Definiert den API-Service für den Zugriff auf vegetarische Mahlzeiten.
 *
 * Die Methode [getVeggieMeals] ruft die Mahlzeiten anhand der angegebenen Kategorie ab.
 */
interface APIService {
    /**
     * Ruft eine Liste von vegetarischen Mahlzeiten ab, gefiltert nach Kategorie.
     *
     * Der Standardwert für den Query-Parameter [category] ist "Dessert".
     *
     * @param category Die Kategorie der Mahlzeiten, standardmäßig "Dessert".
     * @return Eine [VeggieMealsResponse], die die abgerufenen Mahlzeiten enthält.
     */
    @GET("filter.php")
    suspend fun getVeggieMeals(@Query("c") category: String = "Dessert"): VeggieMealsResponse
}

/**
 * Singleton-Objekt, das den Zugriff auf den [APIService] ermöglicht.
 *
 * Die Instanz des API-Service wird lazy initialisiert.
 */
object VeggieMealAPI {
    val retrofitService: APIService by lazy { retrofit.create(APIService::class.java) }
}
