package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.NeoMissDistanceDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoRelativeVelocityDto
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoMissDistanceDtoMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto.NeoRelativeVelocityDtoMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.*
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NearEarthObjectUIMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NeoFeedUiMapper
import com.a9992099300.asteroidsneo.data.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
internal interface UIMappersModule {

    companion object {
        @Provides
        fun provideNeoFeedResultMapper(): ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeed>> {
            return ResultToUIStateMapper()
        }

        @Provides
        fun provideNeoFeedUIResultMapper(asteroidMapper: NeoFeedUiMapper): ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeedUI>> {
            return ResultToUIStateMapper(asteroidMapper)
        }
    }


    @Binds
    fun bindNeoFeedMapper(
        mapper: NeoFeedUiMapper
    ): ModelMapper<NeoFeed, NeoFeedUI>

    @Binds
    fun bindNearEarthObjectMapper(
        mapper: NearEarthObjectUIMapper
    ): ModelMapper<NearEarthObject, NearEarthObjectUI>

    @Binds
    fun bindNearCloseApproachDataMapper(
        mapper: NeoCloseApproachDataUIMapper
    ): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataUI>

}
