package com.a9992099300.asteroidsneo.data




data class NeoFeed(
    val elementCount: Int,
    val asteroidsByDate: Map<String, List<NearEarthObject>>
)


data class NearEarthObject(
    val id: String? = null,
    val name: String? = null,
    val nasaJplUrl: String? = null,
    val absoluteMagnitude: Float? = null,
    val estimatedDiameter: NeoEstimatedDiameter? = null,
    val isPotentiallyHazardousAsteroid: Boolean? = null,
    val closeApproachData: List<NeoCloseApproachData>? = null,
    val orbitalData: NeoOrbitalData? = null,
)


data class NeoEstimatedDiameter(
    val meters: NeoDiameterRange? = null
)


data class NeoDiameterRange(
    val minimumDiameter: Double? = null,
    val maximumDiameter: Double? = null,
)


data class NeoCloseApproachData(
    val approachDate: String? = null,
    val approachEpochDate: Long? = null,
    val relativeVelocity: NeoRelativeVelocity? = null,
    val missDistance: NeoMissDistance? = null,
)


data class NeoRelativeVelocity(
    val kilometersPerSecond: Double? = null
)


data class NeoMissDistance(
    val kilometers: Double? = null,
    val lunar: Double? = null,
)


data class NeoOrbitalData(
    val orbitClass: NeoOrbitClass? = null
)


data class NeoOrbitClass(
   val description: String? = null
)

