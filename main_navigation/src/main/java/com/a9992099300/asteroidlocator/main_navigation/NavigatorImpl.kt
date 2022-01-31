package com.a9992099300.asteroidlocator.main_navigation

import androidx.navigation.NavController
import javax.inject.Inject

class NavigatorImpl @Inject constructor(val nav: NavController) : Navigator {
    var navController = nav
    override fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        is NavigationFlow.AsteroidListFlow -> navController.navigate(MainNavGraphDirections.actionAsteroidListFlow())
        is NavigationFlow.PhotoListFlow -> navController.navigate(MainNavGraphDirections.actionPhotoListFlow())
        is NavigationFlow.SettingFlow -> navController.navigate(MainNavGraphDirections.actionSettingFlow())
        is NavigationFlow.AsteroidGraphFlow -> navController.navigate(MainNavGraphDirections.actionAsteroidGraphFlow())
    }
}



