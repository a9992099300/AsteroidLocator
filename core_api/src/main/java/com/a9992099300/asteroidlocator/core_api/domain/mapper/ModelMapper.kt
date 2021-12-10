package com.a9992099300.asteroidlocator.core_api.domain.mapper

interface ModelMapper<INT, EXT> {

    fun mapToInternalLayer(externalLayerModel: EXT): INT
}
