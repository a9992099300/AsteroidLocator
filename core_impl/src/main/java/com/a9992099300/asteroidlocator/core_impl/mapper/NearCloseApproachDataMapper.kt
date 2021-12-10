package com.a9992099300.asteroidlocator.core_impl.mapper

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoCloseApproachDataMapper @Inject constructor()
    : ModelMapper<NeoCloseApproachData, NeoCloseApproachDataDto> {
        override fun mapToInternalLayer(externalLayerModel: NeoCloseApproachDataDto): NeoCloseApproachData{
            return NeoCloseApproachData(
                externalLayerModel.approachDate,
                externalLayerModel.approachEpochDate
            )
        }
}