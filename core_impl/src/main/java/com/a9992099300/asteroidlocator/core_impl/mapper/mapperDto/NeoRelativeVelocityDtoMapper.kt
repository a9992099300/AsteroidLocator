package com.a9992099300.asteroidlocator.core_impl.mapper.mapperDto

import androidx.lifecycle.Transformations.map
import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import dagger.Reusable
import javax.inject.Inject

internal class NeoRelativeVelocityDtoMapper @Inject constructor()
    : ModelMapper<NeoRelativeVelocity, NeoRelativeVelocityDto>
{
        override fun mapToInternalLayer(externalLayerModel: NeoRelativeVelocityDto): NeoRelativeVelocity{
            return NeoRelativeVelocity(
                externalLayerModel.kilometersPerSecond
            )
        }

    override fun mapToExternalLayer(internalLayerModel: NeoRelativeVelocity): NeoRelativeVelocityDto {
        return NeoRelativeVelocityDto(
            internalLayerModel.kilometersPerSecond
        )
    }
}