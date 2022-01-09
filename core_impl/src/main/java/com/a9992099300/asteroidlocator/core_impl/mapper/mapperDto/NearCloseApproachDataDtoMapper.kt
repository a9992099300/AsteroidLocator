package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

internal class NeoCloseApproachDataDtoMapper @Inject constructor()
    : ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoCloseApproachDataDto): NeoCloseApproachData{
            return NeoCloseApproachData(
                externalLayerModel.asteroidId,
                externalLayerModel.approachDate,
                externalLayerModel.approachEpochDate
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoCloseApproachData): NeoCloseApproachDataDto {
        return NeoCloseApproachDataDto(
            internalLayerModel.asteroidId,
            internalLayerModel.approachDate,
            internalLayerModel.approachEpochDate
        )
    }
}