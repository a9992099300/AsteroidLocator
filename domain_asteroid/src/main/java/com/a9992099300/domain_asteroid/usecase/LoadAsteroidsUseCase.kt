package com.a9992099300.asteroidlocator.home.asteroidList.usecase

import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidsneo.data.NeoFeed
import kotlinx.coroutines.flow.Flow


interface LoadAsteroidsUseCase {
    operator fun invoke (startDate: String,
                         endDate: String,
                         typeList: TypeList): Flow<ResultAsteroid<NeoFeed>>
}
