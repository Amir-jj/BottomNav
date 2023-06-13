package com.example.mygridapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar (
     val  route : String,
     val  title : String,
     val  icon : ImageVector
         ) {

    object  Home :BottomBar(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object  Car :BottomBar(
        route = "car",
        title = "Car",
        icon = Icons.Default.MoreVert
    )
}