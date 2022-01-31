package com.a9992099300.asteroidlocator.core_impl.di

import android.content.Context
import androidx.navigation.NavController
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
internal interface NavigationModule {

    companion object {
        @Provides
        @Reusable
        fun provideNavController (context: Context): NavController {
            return NavController(context)
        }
    }

}