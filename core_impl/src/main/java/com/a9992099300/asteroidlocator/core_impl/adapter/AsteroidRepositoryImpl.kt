package com.a9992099300.asteroidlocator.core_impl.adapter

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.usecases.AsteroidRepository
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidService
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

@Reusable
class AsteroidRepositoryImpl @Inject constructor(
    private var asteroidNetworkSource: AsteroidNetworkSource
): AsteroidRepository {
    override fun getAsteroid (startDate: String, endDate: String)
    = flow {
            try {
                val listAsteroid = asteroidNetworkSource.loadAsteroid(startDate, endDate)
                emit(ResultAsteroid.Success(listAsteroid))
            } catch (throwable: Exception) {
                emit(ResultAsteroid.Error(throwable))
            }
    }.flowOn(Dispatchers.IO)
}