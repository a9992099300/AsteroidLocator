package com.a9992099300.asteroidlocator.core_impl.db.typeconverter

import androidx.room.TypeConverter
import com.a9992099300.asteroidlocator.core_impl.dto.NeoDiameterRangeDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoEstimatedDiameterDto

class NeoEstimatedDiameterDtoTypeConverter: AbstractTypeConverter<NeoEstimatedDiameterDto, String> {
    @TypeConverter
    override fun save(restored: NeoEstimatedDiameterDto): String {
            return "${restored.meters.maximumDiameter} ; ${restored.meters.minimumDiameter}"
    }

    @TypeConverter
    override fun restore(saved: String): NeoEstimatedDiameterDto {
       val savedList = saved.split(" ")
        return NeoEstimatedDiameterDto(
            NeoDiameterRangeDto(savedList.first().toDouble(),
                savedList.last().toDouble())
        )
    }
}