package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.di.scope.UnderRepoScope
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Component

@UnderRepoScope
@Component(modules = [DtoMappersModule::class])
internal interface DtoMappersComponent {

    fun provideNeoFeedMapper(): ModelMapper<NeoFeed, NeoFeedDto>

    fun provideNearEarthObjectMapper(): ModelMapper<NearEarthObject, NearEarthObjectDto>

    fun provideNeoCloseApproachDataMapper(): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>

    companion object {
        private var dtoMappersComponent: DtoMappersComponent? = null

        fun create(): DtoMappersComponent {
            return dtoMappersComponent ?: DaggerDtoMappersComponent.create().also { dtoMappersComponent = it }
        }
    }
}
