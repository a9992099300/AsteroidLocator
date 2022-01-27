package com.a9992099300.asteroidlocator.main.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import java.util.*
import javax.inject.Inject

internal interface SaveAppPreferenceUseCase {
    suspend operator fun invoke(preference: AppPreference)
}