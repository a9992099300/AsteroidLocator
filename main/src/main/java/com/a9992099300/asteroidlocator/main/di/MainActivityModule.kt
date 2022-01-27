package com.a9992099300.asteroidlocator.main.di

import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.home.asteroidList.vm.MainActivityModelFactory
import com.a9992099300.asteroidlocator.main.usecase.LoadAppPreferenceUseCase
import com.a9992099300.asteroidlocator.main.usecase.LoadAppPreferenceUseCaseImpl
import dagger.Binds
import dagger.Module



@Module
internal interface MainActivityModule {
    @Binds
    fun bindViewModelFactory(
        viewModelFactory: MainActivityModelFactory
    ): ViewModelProvider.Factory

    @Binds
    fun bindLoadCase(
        loadAsteroidUseCaseImpl: LoadAppPreferenceUseCaseImpl
    ) : LoadAppPreferenceUseCase

}