package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import com.a9992099300.asteroidlocator.core_impl.shared_preference.AsteroidPreferencesImpl
import dagger.Binds
import dagger.Module


@Module
internal interface SharedPreferencesModule {
    @Binds
    fun bindPreferencesService(
        asteroidPreferencesServiceImpl: AsteroidPreferencesImpl
    ): AsteroidPreferences
}
