package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

internal class NeoCloseApproachDataDtoMapper @Inject constructor(
    private val neoRelativeVelocityDtoMapper: ModelMapper<NeoRelativeVelocity, NeoRelativeVelocityDto>,
    private val neoMissDistanceDtoMapper: ModelMapper<NeoMissDistance, NeoMissDistanceDto>,
)
    : ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>
{
        override fun mapToInternalLayer(externalLayerModel: NeoCloseApproachDataDto): NeoCloseApproachData{
            return NeoCloseApproachData(
                externalLayerModel.asteroidId,
                externalLayerModel.approachDate,
                externalLayerModel.approachEpochDate,
                externalLayerModel.relativeVelocity?.kilometersPerSecond,
                externalLayerModel.missDistance?.kilometers,
                externalLayerModel.missDistance?.lunar
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoCloseApproachData): NeoCloseApproachDataDto {
        return NeoCloseApproachDataDto(
            internalLayerModel.asteroidId,
            internalLayerModel.approachDate,
            internalLayerModel.approachEpochDate,
            neoRelativeVelocityDtoMapper.mapToExternalLayer(
                NeoRelativeVelocity(
                    kilometersPerSecond = internalLayerModel.kilometersPerSecond)),
            neoMissDistanceDtoMapper.mapToExternalLayer(
                NeoMissDistance(
                    kilometers = internalLayerModel.kilometers,
                    lunar = internalLayerModel.lunar
                )
            )
        )
    }
}