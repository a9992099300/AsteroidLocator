package com.a9992099300.asteroidlocator.core_api.di

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*

interface MapperProvider {

    fun provideNeoFeedMapper(): ModelMapper<NeoFeed, NeoFeedDto>

    fun provideNearEarthObjectMapper(): ModelMapper<NearEarthObject, NearEarthObjectDto>

    fun provideNeoCloseApproachDataMapper(): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>

    fun provideNeoEstimatedDiameterMapper(): ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto>

    fun provideNeoDiameterRangeMapper(): ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>
}