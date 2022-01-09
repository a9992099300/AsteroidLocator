package com.a9992099300.asteroidlocator.main_navigation

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
         is  NavigationFlow.AsteroidListFlow -> navController.navigate(MainNavGraphDirections.actionAsteroidListFlow())
        is NavigationFlow.PhotoListFlow -> navController.navigate(MainNavGraphDirections.actionPhotoListFlow())
    }
}