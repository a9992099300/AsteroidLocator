package com.a9992099300.domain_preference.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import javax.inject.Inject

class LoadAppPreferenceUseCaseImpl @Inject constructor (
    private val asteroidPreferences: AsteroidPreferences
): LoadAppPreferenceUseCase {
    override suspend operator fun invoke(): AppPreference {
        return asteroidPreferences.loadAppPreference()
    }
}