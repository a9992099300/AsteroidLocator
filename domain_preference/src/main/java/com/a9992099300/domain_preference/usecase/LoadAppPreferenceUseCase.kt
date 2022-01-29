package com.a9992099300.domain_preference.usecase

import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidPreferences
import java.util.*
import javax.inject.Inject

 interface LoadAppPreferenceUseCase {
    suspend operator fun invoke(): AppPreference
}