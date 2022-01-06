package com.a9992099300.asteroidlocator.core_api.di

import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidsneo.data.*

interface UIMapperProvider {

    fun provideNeoFeedMapper(): ModelMapper<NeoFeed, NeoFeedUI>

    fun provideNearEarthObjectMapper(): ModelMapper<NearEarthObject, NearEarthObjectUI>

    fun provideNeoCloseApproachDataMapper(): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataUI>

    fun provideNeoEstimatedDiameterMapper(): ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterUI>

    fun provideNeoDiameterRangeMapper(): ModelMapper<NeoDiameterRange, NeoDiameterRangeUI>

    fun provideNeoFeedUIResultMapper(): ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>>

}