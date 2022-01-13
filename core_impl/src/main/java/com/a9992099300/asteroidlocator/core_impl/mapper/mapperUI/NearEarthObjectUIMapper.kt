package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject


internal class NearEarthObjectUIMapper @Inject constructor(
    private val neoCloseApproachDataMapper: ModelMapper<NeoCloseApproachData, NeoCloseApproachDataUI>
    ) : ModelMapper<NearEarthObject, NearEarthObjectUI> {
        override fun mapToInternalLayer(externalLayerModel: NearEarthObjectUI): NearEarthObject{
            return NearEarthObject(
                externalLayerModel.id,
                externalLayerModel.name,
                externalLayerModel.nasaJplUrl,
                externalLayerModel.minimumDiameter?.toDouble(),
                externalLayerModel.maximumDiameter?.toDouble(),
                externalLayerModel.isPotentiallyHazardousAsteroid,
                externalLayerModel.closeApproachData?.map{neoCloseApproachDataMapper.mapToInternalLayer(it)},
                externalLayerModel.isFavorite,
                externalLayerModel.description
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NearEarthObject): NearEarthObjectUI {
        return NearEarthObjectUI (
            internalLayerModel.id,
            internalLayerModel.name?.filter{ it != '(' && it != ')'},
            internalLayerModel.nasaJplUrl,
            internalLayerModel.minimumDiameter?.toInt(),
            internalLayerModel.maximumDiameter?.toInt(),
            internalLayerModel.isPotentiallyHazardousAsteroid,
            internalLayerModel.closeApproachData?.map{neoCloseApproachDataMapper.mapToExternalLayer(it)},
            internalLayerModel.isFavorite,
            internalLayerModel.description
        )
    }
}
