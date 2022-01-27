package com.a9992099300.asteroidlocator.core_api.domain.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference

interface AsteroidPreferences {
    suspend fun loadAppPreference(): AppPreference
    suspend fun saveAppPreference(preference: AppPreference)
}