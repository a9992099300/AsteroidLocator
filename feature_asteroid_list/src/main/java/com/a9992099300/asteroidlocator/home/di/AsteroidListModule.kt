package com.a9992099300.asteroidlocator.home.di

import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal interface AsteroidListModule {
    @Binds
    fun bindViewModelFactory(
        viewModelFactory: AsteroidListViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    fun bindLoadCase(
        loadAsteroidUseCaseImpl: LoadAsteroidsUseCaseImpl
    ) : LoadAsteroidsUseCase

    @Binds
    fun bindSaveCase(
        saveAsteroidUseCaseImpl: SaveDeleteAsteroidsUseCaseImpl
    ) : SaveDeleteAsteroidsUseCase
}