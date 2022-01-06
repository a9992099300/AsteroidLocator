package com.a9992099300.asteroidsneo.data

import javax.inject.Inject


data class NeoFeedUI(
    val elementCount: Int,
   // val asteroidsByDate: Map<String, List<NearEarthObject>>
    val asteroidsByDate: List<NearEarthObjectUI>
)


data class NearEarthObjectUI(
    val id: String = " ",
    val name: String = " ",
    val nasaJplUrl: String = " ",
   // val absoluteMagnitude: Float? = null,
    val estimatedDiameter: NeoEstimatedDiameterUI,
    val isPotentiallyHazardousAsteroid: Boolean? = null,
    val closeApproachData: List<NeoCloseApproachDataUI>? ,
    val isFavorite: Boolean = false,
  //  val orbitalData: NeoOrbitalData? = null,
  //  val meters: NeoDiameterRange
)


data class NeoEstimatedDiameterUI  (
    val meters: NeoDiameterRangeUI
)

data class NeoDiameterRangeUI(
    val minimumDiameter: Int? = null,
    val maximumDiameter: Int? = null,
)

data class NeoCloseApproachDataUI(
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

