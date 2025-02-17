package de.syntax_institut.theveggieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.syntax_institut.theveggieapp.ui.theme.TheVeggieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheVeggieAppTheme {
                TheVeggieApp()
            }
        }
    }
}