package de.syntax_institut.theveggieapp.data.repositorie

import de.syntax_institut.theveggieapp.data.local.PLACEHOLDER_VEGGIE_MEALS
import de.syntax_institut.theveggieapp.data.local.VeggieMealsResponse
import de.syntax_institut.theveggieapp.data.remote.APIService

/**
 * Testimplementierung des [VeggieMealsRepositoryInterface].
 *
 * Diese Klasse liefert eine vereinfachte Version des Repositories, die für Test- oder Entwicklungszwecke
 * verwendet werden kann. Anstatt echte API-Aufrufe zu tätigen, gibt die Methode [getVeggieMeals] eine
 * Antwort mit Platzhalter-Daten ([PLACEHOLDER_VEGGIE_MEALS]) zurück.
 *
 * @param apiService Eine Instanz von [APIService], die zur Erfüllung der Schnittstelle benötigt wird.
 */

class VeggieMealsRepoTest(apiService: APIService) : VeggieMealsRepositoryInterface {
    override val api = apiService

    override suspend fun getVeggieMeals(): VeggieMealsResponse {
        return VeggieMealsResponse(PLACEHOLDER_VEGGIE_MEALS)
    }
}