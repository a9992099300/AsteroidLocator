package com.a9992099300.asteroidlocator.core_impl.db

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.NearEarthObjectDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AsteroidLocalSourceImpl
@Inject constructor
   (
    private val asteroidsDao: AsteroidsDao,
    private val neoFeedMapper: ModelMapper<NeoFeed, NeoFeedDto>,
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectDto>
): AsteroidLocalSource {
    override suspend fun loadAsteroids(): NeoFeed {
        return neoFeedMapper.mapToInternalLayer(
            NeoFeedDto(asteroidsDao.getAsteroids().size, mapOf(" " to asteroidsDao.getAsteroids())))
    }

    override suspend fun saveAsteroids(asteroid: NearEarthObject) {
        asteroidsDao.saveAsteroid(nearEarthObjectMapper.mapToExternalLayer(asteroid))
    }

    override suspend fun deleteAsteroids(asteroidId: String) {
        asteroidsDao.deleteAsteroids(asteroidId)
    }

}