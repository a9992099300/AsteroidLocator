package com.a9992099300.asteroidlocator.core_api.di

import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import com.a9992099300.asteroidsneo.data.*

interface SharedPreferenceProvider {
    fun provideSharedPreference(): AsteroidPreferences
}