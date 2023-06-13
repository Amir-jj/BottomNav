package com.example.mygridapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBar.Home.route)
    {
        composable(route=BottomBar.Home.route){
            HomeScreen()
        }
        composable(route = BottomBar.Car.route){
            MenuGrid()
        }
    }
}