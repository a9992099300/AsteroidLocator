package com.a9992099300.asteroidlocator.main_navigation

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController
     //navigate on main thread or nav component crashes sometimes
    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
         is  NavigationFlow.AsteroidListFlow -> navController.navigate(MainNavGraphDirections.actionAsteroidListFlow())
        is NavigationFlow.PhotoListFlow -> navController.navigate(MainNavGraphDirections.actionPhotoListFlow())
    }
}