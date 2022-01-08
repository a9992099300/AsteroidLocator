package com.a9992099300.asteroidlocator.core_impl.db.typeconverter

import androidx.room.TypeConverter
import com.a9992099300.asteroidlocator.core_impl.dto.NeoDiameterRangeDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoEstimatedDiameterDto

class NeoEstimatedDiameterDtoTypeConverter: AbstractTypeConverter<NeoEstimatedDiameterDto, Double?> {
    @TypeConverter
    override fun save(restored: NeoEstimatedDiameterDto): Double? {
            return restored.meters.maximumDiameter
    }

    @TypeConverter
    override fun restore(saved: Double?): NeoEstimatedDiameterDto {
        return NeoEstimatedDiameterDto(
            NeoDiameterRangeDto(saved, saved)
        )
    }
}