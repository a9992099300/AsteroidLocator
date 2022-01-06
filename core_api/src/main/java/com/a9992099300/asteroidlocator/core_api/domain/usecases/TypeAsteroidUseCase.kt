package com.a9992099300.asteroidlocator.core_api.domain.usecases

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.entities.TypeList
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoFeed
import kotlinx.coroutines.flow.Flow

interface TypeAsteroidUseCase {
    fun getAsteroids(startDate: String, endDate: String, typeList: TypeList): Flow<ResultAsteroid<NeoFeed>>
}