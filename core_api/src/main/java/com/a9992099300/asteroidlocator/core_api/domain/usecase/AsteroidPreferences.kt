package com.a9992099300.asteroidlocator.core_api.domain.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.entities.Language

interface AsteroidPreferences {
    suspend fun loadAppPreference(): AppPreference
    suspend fun saveTheme(blackTheme: Boolean)
    suspend fun saveLanguage(language: Language)
}