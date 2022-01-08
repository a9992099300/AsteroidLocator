package com.a9992099300.asteroidlocator.home.asteroidList.usecase


import com.a9992099300.asteroidsneo.data.NearEarthObject

interface SaveDeleteAsteroidsUseCase {
    suspend operator fun invoke(asteroid: NearEarthObject)
}