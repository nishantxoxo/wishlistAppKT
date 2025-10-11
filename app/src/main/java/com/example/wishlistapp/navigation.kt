package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(), navcontroller: NavHostController = rememberNavController()){
    NavHost(startDestination = Screen.HomeScreen.route, navController = navcontroller  ) {
            composable(Screen.HomeScreen.route) {
                HomeView()
            }

    }
}