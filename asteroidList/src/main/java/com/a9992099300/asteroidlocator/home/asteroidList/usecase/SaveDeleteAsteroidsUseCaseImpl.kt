package com.a9992099300.asteroidlocator.home.asteroidList.usecase

import com.a9992099300.asteroidlocator.core_api.data.AsteroidRepository
import com.a9992099300.asteroidsneo.data.NearEarthObject

import dagger.Reusable

import javax.inject.Inject

const val TAG = "debug"

@Reusable
class SaveDeleteAsteroidsUseCaseImpl @Inject constructor(
    private val asteroidRepository: AsteroidRepository,
): SaveDeleteAsteroidsUseCase {
    override suspend fun invoke(asteroid: NearEarthObject) {
        if (asteroid.isFavorite) asteroidRepository.saveAsteroid(asteroid)
         else asteroidRepository.deleteAsteroid(asteroid.id)
    }
}