package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(), navcontroller: NavHostController = rememberNavController()){
    NavHost(startDestination = Screen.HomeScreen.route, navController = navcontroller  ) {
            composable(Screen.HomeScreen.route) {
                HomeView(navcontroller, viewModel)
            }
            composable(Screen.AddScreen.route + "/{id}",
                arguments = listOf(
                    navArgument("id"){
                        type = NavType.LongType
                        defaultValue = 0L
                        nullable = false
                    }
                )
                ) { entry->
                val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
                AddEditDetialView(id = 0L, viewModel, navcontroller)
            }

    }
}