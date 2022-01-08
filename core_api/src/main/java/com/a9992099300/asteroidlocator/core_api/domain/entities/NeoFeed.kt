package com.a9992099300.asteroidsneo.data

import javax.inject.Inject


data class NeoFeed(
    val elementCount: Int,
   // val asteroidsByDate: Map<String, List<NearEarthObject>>
    val asteroidsByDate: List<NearEarthObject>
)


data class NearEarthObject(
    val id: String,
    val name: String,
    val nasaJplUrl: String,
   // val absoluteMagnitude: Float? = null,
    val estimatedDiameter: NeoEstimatedDiameter,
    val isPotentiallyHazardousAsteroid: Boolean,
    val closeApproachData: List<NeoCloseApproachData>?,
    var isFavorite: Boolean = false
  //  val orbitalData: NeoOrbitalData? = null,
  //  val meters: NeoDiameterRange
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
   // val relativeVelocity: NeoRelativeVelocity? = null,
  //  val missDistance: NeoMissDistance? = null,
)

//data class NeoRelativeVelocity(
//    val kilometersPerSecond: Double? = null
//)

//data class NeoMissDistance(
//    val kilometers: Double? = null,
//    val lunar: Double? = null,
//)

//data class NeoOrbitalData(
//    val orbitClass: NeoOrbitClass? = null
//)
//
//
//data class NeoOrbitClass(
//   val description: String? = null
//)

