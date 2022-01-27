package com.a9992099300.asteroidlocator.core_api.di

import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidRepository

interface RepositoryProvider {
    fun provideAsteroidRepository(): AsteroidRepository
}