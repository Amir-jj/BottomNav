package com.example.mygridapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
       bottomBar = { Bottombar(navController =navController )}
    ){
        BottomNavGraph(navController = navController)
    }



}

@Composable
fun Bottombar(navController: NavHostController){
    val  screen = listOf<BottomBar>(
        BottomBar.Home,
        BottomBar.Car
    )
    val navBack by navController.currentBackStackEntryAsState()
    val currentDestination = navBack?.destination

    BottomNavigation() {
        screen.forEach{screen->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController )
        }

    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}