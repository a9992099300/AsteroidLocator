package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoFeedUiMapper @Inject constructor(
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectUI>,
    ) : ModelMapper<NeoFeed, NeoFeedUI> {
        override fun mapToInternalLayer(externalLayerModel: NeoFeedUI): NeoFeed {
            return NeoFeed(
                externalLayerModel.elementCount,
                externalLayerModel.asteroidsByDate.map { nearEarthObjectMapper.mapToInternalLayer(it) }
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoFeed): NeoFeedUI {
        return NeoFeedUI(
            internalLayerModel.elementCount,
            internalLayerModel.asteroidsByDate.map { nearEarthObjectMapper.mapToExternalLayer(it) }
        )
    }
}