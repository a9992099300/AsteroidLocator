package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidlocator.core_impl.mapper.*
import com.a9992099300.asteroidlocator.core_impl.mapper.NearEarthObjectMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.NeoCloseApproachDataMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.NeoDiameterRangeMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.NeoEstimatedDiameterMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.NeoFeeDtoNeoFeedDto
import com.a9992099300.asteroidsneo.data.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
internal interface DtoMappersModule {

    @Binds
    fun bindNeoFeedMapper(
        mapper: NeoFeeDtoNeoFeedDto
    ): ModelMapper<NeoFeed, NeoFeedDto>

    @Binds
    fun bindNearEarthObjectMapper(
        mapper: NearEarthObjectMapper
    ): ModelMapper<NearEarthObject, NearEarthObjectDto>

    @Binds
    fun bindNearCloseApproachDataMapper(
        mapper: NeoCloseApproachDataMapper
    ): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>

    @Binds
    fun bindNeoEstimatedDiameterMapper(
        mapper: NeoEstimatedDiameterMapper
    ): ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto>

    @Binds
    fun bindNeoDiameterRangeMapper(
        mapper: NeoDiameterRangeMapper
    ): ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>
}
