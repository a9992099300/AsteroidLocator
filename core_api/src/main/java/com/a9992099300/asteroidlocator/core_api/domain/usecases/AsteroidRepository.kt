package com.a9992099300.asteroidlocator.core_api.domain.usecases

import com.a9992099300.asteroidsneo.data.NeoFeed

interface AsteroidRepository {
    suspend fun loadAsteroid(startDate: String, endDate: String): NeoFeed
}