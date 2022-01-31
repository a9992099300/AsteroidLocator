package com.a9992099300.asteroidlocator.main_navigation

sealed class NavigationFlow {
    object AsteroidListFlow : NavigationFlow()
    object PhotoListFlow  : NavigationFlow()
    object SettingFlow  : NavigationFlow()
    object AsteroidGraphFlow : NavigationFlow()
}

interface FlowNavigatable {
    fun navigateToFlow(flow: NavigationFlow)
}