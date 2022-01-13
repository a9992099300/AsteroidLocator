package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import javax.inject.Inject



internal class NearEarthObjectDtoMapper @Inject constructor(
    private val neoEstimatedDiameterMapper: ModelMapper<NeoEstimatedDiameter, NeoEstimatedDiameterDto>,
    private val neoCloseApproachDataMapper: ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto>,
    private val neoOrbitalDataMapper: ModelMapper<NeoOrbitalData,  NeoOrbitalDataDto>,
    ) : ModelMapper<NearEarthObject, NearEarthObjectDto> {
        override fun mapToInternalLayer(externalLayerModel: NearEarthObjectDto): NearEarthObject{
            return NearEarthObject(
                externalLayerModel.id,
                externalLayerModel.name,
                externalLayerModel.nasaJplUrl,
                externalLayerModel.estimatedDiameter.meters.maximumDiameter,
                externalLayerModel.estimatedDiameter.meters.minimumDiameter,
                externalLayerModel.isPotentiallyHazardousAsteroid,
                externalLayerModel.closeApproachData?.map{neoCloseApproachDataMapper.mapToInternalLayer(it)},
                externalLayerModel.isFavorite,
                externalLayerModel.orbitalData?.orbitClass?.description
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NearEarthObject): NearEarthObjectDto {
        return NearEarthObjectDto(
            internalLayerModel.id,
            internalLayerModel.name,
            internalLayerModel.nasaJplUrl,
            neoEstimatedDiameterMapper.mapToExternalLayer(
                    NeoEstimatedDiameter(NeoDiameterRange(
                        minimumDiameter = internalLayerModel.minimumDiameter,
                        maximumDiameter = internalLayerModel.maximumDiameter))),
            internalLayerModel.isPotentiallyHazardousAsteroid,
            internalLayerModel.closeApproachData?.map{neoCloseApproachDataMapper.mapToExternalLayer(it)},
            internalLayerModel.isFavorite,
            neoOrbitalDataMapper.mapToExternalLayer(
                NeoOrbitalData(NeoOrbitClass(internalLayerModel.description))
            )
        )
    }
}
