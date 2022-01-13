package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject


internal class NeoFeeDtoNeoFeedDto @Inject constructor(
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectDto>,
    ) : ModelMapper<NeoFeed, NeoFeedDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoFeedDto): NeoFeed {
            return NeoFeed(
                externalLayerModel.elementCount,
                externalLayerModel.asteroidsByDate.values.flatten().map { nearEarthObjectMapper.mapToInternalLayer(it)},
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoFeed): NeoFeedDto {
        return NeoFeedDto(
            internalLayerModel.elementCount,
            mapOf(" " to internalLayerModel.asteroidsByDate.map { nearEarthObjectMapper.mapToExternalLayer(it)})
        )
    }
}