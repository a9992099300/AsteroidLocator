package com.a9992099300.asteroidlocator.core_api.data

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoCloseApproachData
import com.a9992099300.asteroidsneo.data.NeoFeed
import kotlinx.coroutines.flow.Flow

interface AsteroidRepository {
   suspend fun getAsteroids(startDate: String, endDate: String): NeoFeed
   suspend fun getSavedAsteroids(): NeoFeed
   suspend fun saveAsteroid(asteroid: NearEarthObject)
   suspend fun deleteAsteroid(asteroidId: String)
}

