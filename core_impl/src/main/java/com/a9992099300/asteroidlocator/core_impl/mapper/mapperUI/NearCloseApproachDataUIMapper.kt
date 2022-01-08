package com.a9992099300.asteroidlocator.core_impl.mapper.mapperUI

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class NeoCloseApproachDataUIMapper @Inject constructor()
    : ModelMapper<NeoCloseApproachData, NeoCloseApproachDataUI> {
        override fun mapToInternalLayer(externalLayerModel: NeoCloseApproachDataUI): NeoCloseApproachData{
            return NeoCloseApproachData(
                externalLayerModel.asteroidId,
                externalLayerModel.approachDate,
                externalLayerModel.approachEpochDate
            )
        }

    override fun mapToExternalLayer (internalLayerModel: NeoCloseApproachData): NeoCloseApproachDataUI {
        return NeoCloseApproachDataUI(
            internalLayerModel.asteroidId,
            internalLayerModel.approachDate,
            internalLayerModel.approachEpochDate
        )
    }
}