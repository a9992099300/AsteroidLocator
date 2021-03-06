package com.a9992099300.asteroidlocator.core_api.network

import com.a9992099300.asteroidsneo.data.NeoFeed

interface AsteroidNetworkSource {
    suspend fun loadAsteroid(
        startDate: String,
        endDate: String
    ): NeoFeed
}