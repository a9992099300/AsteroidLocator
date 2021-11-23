package com.a9992099300.asteroidlocator.main_navigation

sealed class NavigationFlow {
    object HomeFlow : NavigationFlow()
    class DashboardFlow(val msg: String) : NavigationFlow()
}