package com.a9992099300.asteroidlocator.core_impl.adapter

import com.a9992099300.asteroidsneo.data.NeoFeed

internal interface AsteroidNetworkSource {
    suspend fun loadAsteroid(startDate: String,endDate: String ): NeoFeed
}