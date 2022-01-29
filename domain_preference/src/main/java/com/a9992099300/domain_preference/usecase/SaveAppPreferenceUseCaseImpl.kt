package com.a9992099300.asteroidlocator.main.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.entities.Language
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import javax.inject.Inject

class SaveAppPreferenceUseCaseImpl @Inject constructor (
    private val asteroidPreferences: AsteroidPreferences
): SaveAppPreferenceUseCase{

    override suspend fun invoke(blackTheme: Boolean) {
        return asteroidPreferences.saveTheme(blackTheme)
    }

    override suspend fun invoke(language: Language) {
        return asteroidPreferences.saveLanguage(language)
    }

}