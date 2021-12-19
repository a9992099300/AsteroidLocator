package com.a9992099300.asteroidlocator.home.di

import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.home.asteroidList.AsteroidListViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal interface AsteroidListModule {
    @Binds
    fun bindViewModelFactory(
        viewModelFactory: AsteroidListViewModelFactory
    ): ViewModelProvider.Factory
}