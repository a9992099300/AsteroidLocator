package com.a9992099300.asteroidlocator.core_impl.repository

import com.a9992099300.asteroidlocator.core_api.domain.usecase.AsteroidRepository
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidLocalSource
import com.a9992099300.asteroidlocator.core_api.network.AsteroidNetworkSource
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject


@Reusable
internal class AsteroidRepositoryImpl @Inject constructor(
    private val asteroidNetworkSource: AsteroidNetworkSource,
    private val asteroidLocalSource: AsteroidLocalSource
): AsteroidRepository {

    override suspend fun getAsteroids(
        startDate: String,
        endDate: String
    ): NeoFeed {
        return asteroidNetworkSource.loadAsteroid(startDate, endDate)
    }

    override suspend fun getSavedAsteroids(): NeoFeed {
        return asteroidLocalSource.loadAsteroids()
    }

    override suspend fun saveAsteroid(asteroid: NearEarthObject) {
        asteroidLocalSource.saveAsteroids(asteroid)
    }

    override suspend fun deleteAsteroid(asteroidId: String) {
        asteroidLocalSource.deleteAsteroids(asteroidId)
    }

}

