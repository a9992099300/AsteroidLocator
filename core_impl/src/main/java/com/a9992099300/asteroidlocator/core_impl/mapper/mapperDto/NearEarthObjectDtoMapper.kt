package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NearEarthObjectDtoMapper @Inject constructor(
    private val neoEstimatedDiameterMapper: ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto>,
    private val neoDiameterRangeMapper: ModelMapper<NeoDiameterRange, NeoDiameterRangeDto>,
    private val neoCloseApproachDataMapper: ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>,
   // private val NeoMissDistanceMapper: ModelMapper<NeoMissDistance, NeoMissDistanceDto>,

    ) : ModelMapper<NearEarthObject, NearEarthObjectDto> {
        override fun mapToInternalLayer(externalLayerModel: NearEarthObjectDto): NearEarthObject{
            return NearEarthObject(
                externalLayerModel.id,
                externalLayerModel.name,
                externalLayerModel.nasaJplUrl,
               // neoDiameterRangeMapper.mapToInternalLayer(externalLayerModel.estimatedDiameter.meters),
                neoEstimatedDiameterMapper.mapToInternalLayer(externalLayerModel.estimatedDiameter),
                externalLayerModel.isPotentiallyHazardousAsteroid,
                externalLayerModel.closeApproachData?.map{neoCloseApproachDataMapper.mapToInternalLayer(it)},
                externalLayerModel.isFavorite
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NearEarthObject): NearEarthObjectDto {
        return NearEarthObjectDto(
            internalLayerModel.id,
            internalLayerModel.name,
            internalLayerModel.nasaJplUrl,
            // neoDiameterRangeMapper.mapToInternalLayer(externalLayerModel.estimatedDiameter.meters),
            neoEstimatedDiameterMapper.mapToExternalLayer(internalLayerModel.estimatedDiameter),
            internalLayerModel.isPotentiallyHazardousAsteroid,
            internalLayerModel.closeApproachData?.map{neoCloseApproachDataMapper.mapToExternalLayer(it)},
            internalLayerModel.isFavorite
        )
    }
}