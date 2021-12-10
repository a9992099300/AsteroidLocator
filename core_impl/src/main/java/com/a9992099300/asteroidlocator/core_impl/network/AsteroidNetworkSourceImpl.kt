package com.a9992099300.asteroidlocator.core_impl.network

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.adapter.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class AsteroidNetworkSourceImpl @Inject constructor(
    private val asteroidService: AsteroidService,
    private val asteroidMapper: ModelMapper<NeoFeed, NeoFeedDto>,
) : AsteroidNetworkSource {
    override suspend fun loadAsteroid(startDate: String, endDate: String): NeoFeed {
        return asteroidMapper.mapToInternalLayer(asteroidService.loadAsteroid(startDate,endDate))
    }

}
