package com.a9992099300.asteroidlocator.core_impl.mapper

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoEstimatedDiameterMapper @Inject constructor(
    private val neoDiameterRangeMapper: ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>,

    ) : ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoEstimatedDiameterDto): NeoEstimatedDiameter{
            return NeoEstimatedDiameter(
                neoDiameterRangeMapper.mapToInternalLayer(externalLayerModel.meters)
            )
        }
}