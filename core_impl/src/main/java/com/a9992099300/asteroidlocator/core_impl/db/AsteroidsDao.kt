package com.a9992099300.asteroidlocator.core_impl.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.a9992099300.asteroidlocator.core_impl.dto.NearEarthObjectDto
import com.a9992099300.asteroidlocator.core_impl.dto.NeoCloseApproachDataDto

@Dao
interface AsteroidsDao {

    @Query("SELECT * FROM Asteroids")
    suspend fun getAsteroids(): List<NearEarthObjectDto>

    @Query("SELECT * FROM NeoCloseApproachData")
    suspend fun getDates(): List<NeoCloseApproachDataDto>

    @Query("DELETE FROM Asteroids WHERE id = :asteroidId")
    suspend fun deleteAsteroids(asteroidId: String)

    @Insert
    suspend fun saveAsteroid(asteroid: NearEarthObjectDto )

    @Insert
    suspend fun saveData(neoCloseApproachData: NeoCloseApproachDataDto)
}