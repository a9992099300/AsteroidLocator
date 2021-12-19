package com.a9992099300.asteroidlocator.core_api.domain.mapper

import com.a9992099300.asteroidlocator.core_impl.dto.NearEarthObjectDto

interface ModelMapper<INT, EXT> {

    fun mapToInternalLayer(externalLayerModel: EXT): INT
}
