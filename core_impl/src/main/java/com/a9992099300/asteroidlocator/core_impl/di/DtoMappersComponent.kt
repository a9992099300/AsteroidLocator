package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Component
import dagger.Reusable
import javax.inject.Scope
import javax.inject.Singleton

@MapperScope
@Component(modules = [DtoMappersModule::class])
interface DtoMappersComponent {

    fun provideNeoFeedMapper(): ModelMapper<NeoFeed, NeoFeedDto>

    fun provideNearEarthObjectMapper(): ModelMapper<NearEarthObject, NearEarthObjectDto>

    fun provideNeoCloseApproachDataMapper(): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>

   // fun provideNeoEstimatedDiameterMapper(): ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto>

  //  fun provideNeoDiameterRangeMapper(): ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>

    companion object {
        private var dtoMappersComponent: DtoMappersComponent? = null

        fun create(): DtoMappersComponent {
            return dtoMappersComponent ?: DaggerDtoMappersComponent.create().also { dtoMappersComponent = it }
        }
    }
}
@Scope
annotation class MapperScope