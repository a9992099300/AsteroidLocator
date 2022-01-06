package com.a9992099300.asteroidlocator.home.di

import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.core_api.domain.usecases.TypeAsteroidUseCase
import com.a9992099300.asteroidlocator.home.asteroidList.usecase.TypeAsteroidUseCaseImpl
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
    fun bindUseCase(
        typeAsteroidUseCaseImpl: TypeAsteroidUseCaseImpl
    ) : TypeAsteroidUseCase
}