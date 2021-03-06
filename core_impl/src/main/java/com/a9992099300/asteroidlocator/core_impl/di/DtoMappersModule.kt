package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.*
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NearEarthObjectDtoMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoCloseApproachDataDtoMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoDiameterRangeDtoMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoEstimatedDiameterDtoMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoFeeDtoNeoFeedDto
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoOrbitalDataMapper
import com.a9992099300.asteroidsneo.data.*
import dagger.Binds
import dagger.Module


@Module
internal interface DtoMappersModule {

    @Binds
    fun bindNeoFeedMapper(
        mapper: NeoFeeDtoNeoFeedDto
    ): ModelMapper<NeoFeed, NeoFeedDto>

    @Binds
    fun bindNearEarthObjectMapper(
        dtoMapper: NearEarthObjectDtoMapper
    ): ModelMapper<NearEarthObject, NearEarthObjectDto>

    @Binds
    fun bindNearCloseApproachDataMapper(
        dtoMapper: NeoCloseApproachDataDtoMapper
    ): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>

    @Binds
    fun bindNeoEstimatedDiameterMapper(
        dtoMapper: NeoEstimatedDiameterDtoMapper
    ): ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto>

    @Binds
    fun bindNeoDiameterRangeMapper(
        dtoMapper: NeoDiameterRangeDtoMapper
    ): ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>

    @Binds
    fun bindNeoOrbitalDataMapper(
        dtoMapper: NeoOrbitalDataMapper
    ): ModelMapper<NeoOrbitalData,  NeoOrbitalDataDto>

    @Binds
    fun bindNeoOrbitalClassMapper(
        dtoMapper: NeoOrbitalClassMapper
    ): ModelMapper<NeoOrbitClass,  NeoOrbitClassDto>

    @Binds
    fun bindNeoMissDistanceDtoMapper(
        dtoMapper: NeoMissDistanceDtoMapper
    ): ModelMapper<NeoMissDistance,  NeoMissDistanceDto>

    @Binds
    fun bindNeoRelativeVelocityDtoMapper(
        dtoMapper: NeoRelativeVelocityDtoMapper
    ): ModelMapper<NeoRelativeVelocity, NeoRelativeVelocityDto>
}
