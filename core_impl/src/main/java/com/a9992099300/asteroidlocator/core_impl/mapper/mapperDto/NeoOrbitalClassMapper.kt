package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.NeoOrbitClassDto
import com.a9992099300.asteroidsneo.data.NeoOrbitClass
import javax.inject.Inject

internal class NeoOrbitalClassMapper @Inject constructor()
    : ModelMapper<NeoOrbitClass, NeoOrbitClassDto> {
    override fun mapToInternalLayer(externalLayerModel: NeoOrbitClassDto): NeoOrbitClass {
        return NeoOrbitClass(
            externalLayerModel.description
        )
    }

    override fun mapToExternalLayer(internalLayerModel: NeoOrbitClass): NeoOrbitClassDto {
        return NeoOrbitClassDto(
            internalLayerModel.description
        )
    }
}