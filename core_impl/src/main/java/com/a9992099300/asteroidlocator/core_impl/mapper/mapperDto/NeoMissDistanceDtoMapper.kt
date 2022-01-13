package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

internal class NeoMissDistanceDtoMapper @Inject constructor()
    : ModelMapper<NeoMissDistance, NeoMissDistanceDto>
{
        override fun mapToInternalLayer(externalLayerModel: NeoMissDistanceDto): NeoMissDistance{
            return NeoMissDistance(
                externalLayerModel.kilometers,
                externalLayerModel.lunar
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoMissDistance): NeoMissDistanceDto {
        return NeoMissDistanceDto(
            internalLayerModel.kilometers,
            internalLayerModel.lunar
        )
    }
}