package com.a9992099300.asteroidlocator.home.usecase

import com.a9992099300.asteroidlocator.core_api.domain.usecases.AsteroidRepository
import com.a9992099300.asteroidsneo.data.NeoFeed
import dagger.Reusable
import javax.inject.Inject

//@Reusable
//class LoadAsteroidList @Inject constructor(
//  private val asteroidRepository: AsteroidRepository
//)
//{
//    suspend operator fun invoke(startDate: String, endDate: String): Result<NeoFeed> {
//        val asteroidList = asteroidRepository.loadAsteroid(startDate, endDate)
//        return asteroidList
//    }
//}