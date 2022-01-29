package com.a9992099300.setting.di

import androidx.lifecycle.ViewModelProvider
import com.a9992099300.asteroidlocator.main.usecase.SaveAppPreferenceUseCase
import com.a9992099300.asteroidlocator.main.usecase.SaveAppPreferenceUseCaseImpl
import com.a9992099300.setting.vm.SettingModelFactory
import dagger.Binds
import dagger.Module

@Module
internal interface SettingModule {
    @Binds
    fun bindViewModelFactory(
        viewModelFactory: SettingModelFactory
    ): ViewModelProvider.Factory

    @Binds
    fun bindLoadCase(
        saveAsteroidUseCaseImpl: SaveAppPreferenceUseCaseImpl
    ) : SaveAppPreferenceUseCase

}