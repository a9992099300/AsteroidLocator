package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject


internal class NeoEstimatedDiameterUIMapper @Inject constructor(
    private val neoDiameterRangeMapper: ModelMapper<NeoDiameterRange, NeoDiameterRangeUI>,

    ) : ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterUI> {
        override fun mapToInternalLayer(externalLayerModel: NeoEstimatedDiameterUI): NeoEstimatedDiameter{
            return NeoEstimatedDiameter(
                neoDiameterRangeMapper.mapToInternalLayer(externalLayerModel.meters)
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoEstimatedDiameter): NeoEstimatedDiameterUI {
        return NeoEstimatedDiameterUI(
            neoDiameterRangeMapper.mapToExternalLayer(internalLayerModel.meters)
        )
    }
}