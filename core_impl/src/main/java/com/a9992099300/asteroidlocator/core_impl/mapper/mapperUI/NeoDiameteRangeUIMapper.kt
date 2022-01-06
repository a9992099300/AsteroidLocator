package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoDiameterRangeUIMapper @Inject constructor(
    //private val neoDiameterRangeMapper: ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>,
    //private val NeoMissDistanceMapper: ModelMapper<NeoMissDistance, NeoMissDistanceDto>,

    ) : ModelMapper<NeoDiameterRange, NeoDiameterRangeUI> {
        override fun mapToInternalLayer(externalLayerModel: NeoDiameterRangeUI): NeoDiameterRange{
            return NeoDiameterRange(
                externalLayerModel.minimumDiameter?.toDouble(),
                externalLayerModel.maximumDiameter?.toDouble(),
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoDiameterRange): NeoDiameterRangeUI {
        return NeoDiameterRangeUI(
            (Math.round(internalLayerModel.minimumDiameter!!).toInt()),
          //  internalLayerModel.minimumDiameter,
            (Math.round(internalLayerModel.maximumDiameter!!).toInt())
         //   (Math.round((asteroid.estimatedDiameter.meters.maximumDiameter!!).toDouble()))
        )
    }
}