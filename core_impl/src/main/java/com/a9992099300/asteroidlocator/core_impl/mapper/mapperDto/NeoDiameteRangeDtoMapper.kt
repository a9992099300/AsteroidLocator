package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject


internal class NeoDiameterRangeDtoMapper @Inject constructor(

    ) : ModelMapper<NeoDiameterRange, NeoDiameterRangeDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoDiameterRangeDto): NeoDiameterRange{
            return NeoDiameterRange(
                externalLayerModel.minimumDiameter,
                externalLayerModel.maximumDiameter,
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoDiameterRange): NeoDiameterRangeDto {
        return NeoDiameterRangeDto(
            internalLayerModel.minimumDiameter,
            internalLayerModel.maximumDiameter,
        )
    }
}