package com.a9992099300.asteroidsneo.data

import javax.inject.Inject


data class NeoFeed(
    val elementCount: Int,
    val asteroidsByDate: List<NearEarthObject>
)

data class NearEarthObject(
    val id: String,
    val name: String?,
    val nasaJplUrl: String?,
    val estimatedDiameter: NeoEstimatedDiameter,
    val isPotentiallyHazardousAsteroid: Boolean?,
    val closeApproachData: List<NeoCloseApproachData>?,
    var isFavorite: Boolean = false
)

data class NeoEstimatedDiameter  (
    val meters: NeoDiameterRange
)

data class NeoDiameterRange(
    val minimumDiameter: Double? = null,
    val maximumDiameter: Double? = null,
)

data class NeoCloseApproachData(
    val asteroidId: String = " ",
    val approachDate: String? = null,
    val approachEpochDate: Long? = null,
)


