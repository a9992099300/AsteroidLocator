package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.ContextProvider
import com.a9992099300.asteroidlocator.core_api.di.SharedPreferenceProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPreferencesModule::class], dependencies = [ContextProvider::class])
internal interface SharedPreferencesComponent: SharedPreferenceProvider
