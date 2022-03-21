package com.a9992099300.asteroidlocator.home.di

import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.LoadAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.SaveDeleteAsteroidsUseCaseImpl
import com.a9992099300.asteroidlocator.home.asteroidList.vm.AsteroidListViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
internal interface AsteroidListModule {

    companion object {

        @Provides
        fun providesIoDispatcher(): CoroutineDispatcher {
            return Dispatchers.IO
        }
    }

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