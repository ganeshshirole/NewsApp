package com.accretionapps.newsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.accretionapps.newsapp.domain.model.newspapers.Newspaper
import com.accretionapps.newsapp.presentation.theme.NewsAppTheme
import com.accretionapps.newsapp.presentation.ui.screens.newsdetails.NewsScreen
import com.accretionapps.newsapp.presentation.ui.screens.newspapers.NewspapersScreen
import kotlinx.serialization.json.Json

@Composable
fun NewsApp() {
    NewsAppTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                NewspapersScreen(navController = navController)
            }
            composable(
                "news/{newspaper}",
                arguments = listOf(navArgument("newspaper") { type = NavType.StringType })
            ) { backStackEntry ->
                val json = backStackEntry.arguments?.getString("newspaper") ?: ""
                val newsPaper = Json.decodeFromString<Newspaper>(json)
                NewsScreen(
                    navController = navController,
                    newsPaper = newsPaper
                )
            }
        }
    }
}