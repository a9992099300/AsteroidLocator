package com.a9992099300.asteroidlocator.main_navigation.di

import android.content.Context
import androidx.navigation.NavController
import com.a9992099300.asteroidlocator.main_navigation.Navigator
import com.a9992099300.asteroidlocator.main_navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
interface NavigatorModule {

    @Binds
    fun bindNavigator(navigatorImpl: NavigatorImpl): Navigator
}