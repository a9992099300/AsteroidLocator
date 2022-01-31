package com.a9992099300.asteroidlocator.core_api.di

import android.content.Context
import androidx.navigation.NavController

interface NavigationProvider {
    fun provideNavigation(): NavController
}