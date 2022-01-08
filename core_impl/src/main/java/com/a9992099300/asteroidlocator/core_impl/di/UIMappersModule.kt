package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.UI.UIState
import com.a9992099300.asteroidlocator.core_api.domain.ResultAsteroid
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.*
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NearEarthObjectUIMapper
//import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NeoCloseApproachDataUIMapper
//import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NeoDiameterRangeUIMapper
//import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NeoEstimatedDiameterUIMapper
import com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI.NeoFeedUiMapper
import com.a9992099300.asteroidsneo.data.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
internal interface UIMappersModule {

    @Module
    companion object {
        @Provides
        @Reusable
        fun provideNeoFeedResultMapper(): ModelMapper<ResultAsteroid<NeoFeed>, UIState<NeoFeed>> {
            return ResultToUIStateMapper()
        }

        @Provides
        @Reusable
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
        dtoMapper: NearEarthObjectUIMapper
    ): ModelMapper<NearEarthObject, NearEarthObjectUI>

    @Binds
    fun bindNearCloseApproachDataMapper(
        dtoMapper: NeoCloseApproachDataUIMapper
    ): ModelMapper<NeoCloseApproachData, NeoCloseApproachDataUI>

    @Binds
    fun bindNeoEstimatedDiameterMapper(
        dtoMapper: NeoEstimatedDiameterUIMapper
    ): ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterUI>

    @Binds
    fun bindNeoDiameterRangeMapper(
        dtoMapper: NeoDiameterRangeUIMapper
    ): ModelMapper<NeoDiameterRange, NeoDiameterRangeUI>
}
