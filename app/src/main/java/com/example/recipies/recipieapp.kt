package com.example.recipies

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun recipeapp(navController: NavHostController) {
    val recipieViewmodel: MainViewmodel = viewModel()
    val viewstate by recipieViewmodel.categoriesstate

    NavHost(navController = navController, startDestination = screen.Recipiescreen.route) {
        composable(screen.Recipiescreen.route) {
            recipiescreen(viewstate = viewstate, navigatetodeatil = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(screen.Detailscreen.route)
            })
        }
        composable(screen.Detailscreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<category>("cat")
                    ?: category("", "", "", "")
            categorydetailscreen(category = category)
        }
    }
}