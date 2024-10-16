package com.example.librarian.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.librarian.viewmodel.BooksViewModel

@Composable
fun NavGraph(startDestination: String = "main") {
    val navController = rememberNavController()
    NavHost(navController, startDestination) {
        composable("main") {
            MainScreen(onNavigateToInfo = { navController.navigate("info") })
        }
        composable("info") {
            InfoScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
