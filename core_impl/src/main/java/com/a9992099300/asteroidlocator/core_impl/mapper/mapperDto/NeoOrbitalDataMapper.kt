package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.NeoCloseApproachDataDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoDiameterRangeDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoOrbitClassDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoOrbitalDataDto
import com.a9992099300.asteroidsneo.data.NeoCloseApproachData
import com.a9992099300.asteroidsneo.data.NeoDiameterRange
import com.a9992099300.asteroidsneo.data.NeoOrbitClass
import com.a9992099300.asteroidsneo.data.NeoOrbitalData
import javax.inject.Inject



internal class NeoOrbitalDataMapper @Inject constructor(
    private val neoOrbitalClassMapper: ModelMapper<NeoOrbitClass, NeoOrbitClassDto>,
)
    : ModelMapper<NeoOrbitalData, NeoOrbitalDataDto> {
    override fun mapToInternalLayer(externalLayerModel: NeoOrbitalDataDto): NeoOrbitalData {
        return NeoOrbitalData(
            externalLayerModel.orbitClass?.let { neoOrbitalClassMapper.mapToInternalLayer(it) }
        )
    }

    override fun mapToExternalLayer(internalLayerModel: NeoOrbitalData): NeoOrbitalDataDto {
        return NeoOrbitalDataDto(
            internalLayerModel.orbitClass?.let { neoOrbitalClassMapper.mapToExternalLayer(it) }
        )
    }
}