package com.a9992099300.asteroidsneo.data

import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.inject.Inject


data class NeoFeed(
    val elementCount: Int,
    val asteroidsByDate: List<NearEarthObject>
)

data class NearEarthObject(
    val id: String,
    val name: String?,
    val nasaJplUrl: String?,
    val minimumDiameter: Double?,
    val maximumDiameter: Double?,
    val isPotentiallyHazardousAsteroid: Boolean?,
    val closeApproachData: List<NeoCloseApproachData>?,
    var isFavorite: Boolean,
    val description: String?
)

data class NeoEstimatedDiameter  (
    val meters: NeoDiameterRange
)

data class NeoDiameterRange(
    val minimumDiameter: Double?,
    val maximumDiameter: Double?,
)

data class NeoCloseApproachData(
    val asteroidId: String,
    val approachDate: String?,
    val approachEpochDate: Long?,
    val kilometersPerSecond: Double?,
    val kilometers: Double?,
    val lunar: Double?,
)

data class NeoRelativeVelocity(
    val kilometersPerSecond: Double?,
)

data class NeoMissDistance(
     val kilometers: Double?,
     val lunar: Double?,
)

data class NeoOrbitalData(
    val orbitClass: NeoOrbitClass?
)

data class NeoOrbitClass(
    val description: String?
)



//
//data class NeoFeed(
//    val elementCount: Int,
//    val asteroidsByDate: List<NearEarthObject>
//)

//data class NearEarthObject(
//    val id: String,
//    val name: String?,
//    val nasaJplUrl: String?,
//    val estimatedDiameter: NeoEstimatedDiameter,
//    val isPotentiallyHazardousAsteroid: Boolean?,
//    val closeApproachData: List<NeoCloseApproachData>?,
//    var isFavorite: Boolean = false
//)
//
//data class NeoEstimatedDiameter  (
//    val meters: NeoDiameterRange
//)
//
//data class NeoDiameterRange(
//    val minimumDiameter: Double? = null,
//    val maximumDiameter: Double? = null,
//)
//
//data class NeoCloseApproachData(
//    val asteroidId: String = " ",
//    val approachDate: String? = null,
//    val approachEpochDate: Long? = null,
//)


