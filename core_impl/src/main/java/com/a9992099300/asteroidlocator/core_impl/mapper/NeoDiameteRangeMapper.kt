package com.a9992099300.asteroidlocator.core_impl.mapper

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoDiameterRangeMapper @Inject constructor(
    //private val neoDiameterRangeMapper: ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>,
    //private val NeoMissDistanceMapper: ModelMapper<NeoMissDistance, NeoMissDistanceDto>,

    ) : ModelMapper<NeoDiameterRange, NeoDiameterRangeDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoDiameterRangeDto): NeoDiameterRange{
            return NeoDiameterRange(
                externalLayerModel.minimumDiameter,
                externalLayerModel.maximumDiameter,
            )
        }
}