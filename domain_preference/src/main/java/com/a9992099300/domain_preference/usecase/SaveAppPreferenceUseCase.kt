package com.a9992099300.asteroidlocator.main.usecase


import com.a9992099300.asteroidlocator.core_api.domain.entities.AppPreference
import com.a9992099300.asteroidlocator.core_api.domain.entities.Language
import java.util.*

 interface SaveAppPreferenceUseCase {
    suspend operator fun invoke(blackTheme: Boolean)
    suspend operator fun invoke(language: Language)
}
