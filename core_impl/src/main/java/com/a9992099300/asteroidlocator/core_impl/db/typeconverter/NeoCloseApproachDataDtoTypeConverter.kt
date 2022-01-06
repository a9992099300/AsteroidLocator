package com.a9992099300.asteroidlocator.core_impl.db.typeconverter

import androidx.room.TypeConverter
import com.a9992099300.asteroidlocator.core_impl.dto.NeoCloseApproachDataDto
import java.util.*

class NeoCloseApproachDataDtoTypeConverter: AbstractTypeConverter<NeoCloseApproachDataDto, String?>{
    @TypeConverter
    override fun save(restored: NeoCloseApproachDataDto): String? {
        return restored.approachDate
    }

    @TypeConverter
    override fun restore(saved: String?): NeoCloseApproachDataDto {
        return NeoCloseApproachDataDto(saved, saved?.toLong())
    }


}

