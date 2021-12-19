package com.a9992099300.asteroidlocator.core_impl.mapper

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoFeeDtoNeoFeedDto @Inject constructor(
    private val nearEarthObjectMapper: ModelMapper<NearEarthObject, NearEarthObjectDto>,
    ) : ModelMapper<NeoFeed, NeoFeedDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoFeedDto): NeoFeed {
            return NeoFeed(
                externalLayerModel.elementCount,
               // nearEarthObjectMapper.mapToInternalLayer(externalLayerModel.asteroidsByDate.value)
               externalLayerModel.asteroidsByDate.values.flatten().map { nearEarthObjectMapper.mapToInternalLayer(it)},
               // nearEarthObjectMapper.mapToInternalLayer(externalLayerModel.asteroidsByDate.flatMap {  })
                //externalLayerModel.asteroidsByDate.map{nearEarthObjectMapper.mapToInternalLayer(it)}
           // nearEarthObjectMapper.mapToInternalLayer(externalLayerModel.asteroidsByDate.values)
            )
        }
}