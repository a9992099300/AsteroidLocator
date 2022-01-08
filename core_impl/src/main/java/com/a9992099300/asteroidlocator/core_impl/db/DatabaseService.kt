package com.a9992099300.asteroidlocator.core_impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.a9992099300.asteroidlocator.core_impl.db.typeconverter.NeoEstimatedDiameterDtoTypeConverter
import com.a9992099300.asteroidlocator.core_impl.dto.NearEarthObjectDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoCloseApproachDataDto

@Database(version = 1, entities = [NearEarthObjectDto::class, NeoCloseApproachDataDto::class])
@TypeConverters(
    NeoEstimatedDiameterDtoTypeConverter::class
)
abstract class DatabaseService : RoomDatabase() {
    abstract fun getAsteroidsDao(): AsteroidsDao
}
