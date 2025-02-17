package de.syntax_institut.theveggieapp.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface APIService {
    @GET("filter.php")
    suspend fun getVeggieMeals(@Query("c") category: String = "Vegetarian"): VeggieMealsResponse
}

object VeggieMealAPI {
    val retrofitService: APIService by lazy { retrofit.create(APIService::class.java) }
}