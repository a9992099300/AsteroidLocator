package com.a9992099300.asteroidlocator.main.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import javax.inject.Inject

class SaveAppPreferenceUseCaseImpl @Inject constructor (
    private val asteroidPreferences: AsteroidPreferences
): SaveAppPreferenceUseCase{
    override suspend operator fun invoke(preference: AppPreference) {
        return asteroidPreferences.saveAppPreference(preference)
    }

}