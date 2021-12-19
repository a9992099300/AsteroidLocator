package com.a9992099300.asteroidlocator.core_api.domain.usecases

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidsneo.data.NeoFeed
import kotlinx.coroutines.flow.Flow

interface AsteroidRepository {
   fun getAsteroid(
      startDate: String, endDate: String
 ): Flow<ResultAsteroid<NeoFeed>>
}