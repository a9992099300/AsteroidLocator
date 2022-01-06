package com.a9992099300.asteroidlocator.core_impl.db

import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoFeed

interface AsteroidLocalSource {

    suspend fun loadAsteroids(): NeoFeed

    suspend fun saveAsteroids(asteroid: NearEarthObject)

    suspend fun deleteAsteroids(asteroidId: String)

}