package com.a9992099300.asteroidlocator.core_impl.network

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_api.network.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AsteroidNetworkSourceImpl @Inject constructor(
    private val asteroidApi: AsteroidApi,
    private val asteroidMapper: ModelMapper<NeoFeed, NeoFeedDto>,
) : AsteroidNetworkSource {

    override suspend fun loadAsteroid(
        startDate: String,
        endDate: String
    ): NeoFeed {
        return asteroidMapper.mapToInternalLayer(asteroidApi.loadAsteroid(
          startDate,endDate
        ))
    }

}
