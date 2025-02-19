package de.syntax_institut.theveggieapp

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import de.syntax_institut.theveggieapp.ui.app.TheVeggieApp
import org.junit.Rule
import org.junit.Test


class AktualisierungTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun refreshButton_displaysCorrectText() {
        rule.setContent { TheVeggieApp() }

        rule.onNodeWithTag("refreshButton").performClick()

        //rule.onNodeWithTag("mealsText").assertTextEquals("(${PLACEHOLDER_VEGGIE_MEALS.count()} Gerichte)")

        val text = rule.onNodeWithTag("mealsText").fetchSemanticsNode().config.getOrNull(
            SemanticsProperties.Text)!!
        val digits = text.first().filter { it.isDigit() }
        val number = digits.toString().toInt()
        assert(number > 0)
    }

    @Test
    fun addFavoriteButtonTest() {
        rule.setContent { TheVeggieApp() }

        rule.onAllNodesWithTag("addFavButton")
            .onFirst()
            .performClick()

        rule.onNodeWithTag("favBadgedCount", useUnmergedTree = true).assertTextEquals("1")

    }
}