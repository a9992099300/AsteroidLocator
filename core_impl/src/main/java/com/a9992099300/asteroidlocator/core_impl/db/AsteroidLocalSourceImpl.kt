package com.a9992099300.asteroidlocator.core_impl.db

import android.util.Log
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.NearEarthObjectDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoCloseApproachDataDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NearEarthObject
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject

const val TAG = "debug"

@Reusable
class AsteroidLocalSourceImpl
@Inject constructor
    (
    private val asteroidsDao: AsteroidsDao,
    private val neoFeedMapper: ModelMapper<NeoFeed, NeoFeedDto>,
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectDto>
) : AsteroidLocalSource {
    override suspend fun loadAsteroids(): NeoFeed {
        val asteroidList = mutableListOf<NearEarthObjectDto>()
        val neoCloseApproachData = asteroidsDao.getDates()

        asteroidsDao.getAsteroids().forEach { asteroid ->
            asteroid.closeApproachData = neoCloseApproachData.filter {
                it.asteroidId == asteroid.id
            }
            asteroidList.add(asteroid)
        }

        return neoFeedMapper.mapToInternalLayer(
            NeoFeedDto(
                asteroidsDao.getAsteroids().size,
                mapOf(" " to asteroidList)
            )
        )
    }

    override suspend fun saveAsteroids(asteroid: NearEarthObject) {
        val asteroidDto = nearEarthObjectMapper.mapToExternalLayer(asteroid)
        Log.d(TAG, "click source $asteroid")
        asteroidsDao.saveAsteroid(asteroidDto)
        asteroidsDao.saveData(
            NeoCloseApproachDataDto(
                asteroidDto.id,
                asteroidDto.closeApproachData?.first()?.approachDate,
                asteroidDto.closeApproachData?.first()?.approachEpochDate
            )
        )
    }

    override suspend fun deleteAsteroids(asteroidId: String) {
        asteroidsDao.deleteAsteroids(asteroidId)
    }
}