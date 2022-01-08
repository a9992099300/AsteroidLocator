package com.a9992099300.asteroidsneo.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class NeoFeedUI(
    val elementCount: Int,
   // val asteroidsByDate: Map<String, List<NearEarthObject>>
    val asteroidsByDate: List<NearEarthObjectUI>
) : Parcelable{

}

@Parcelize
data class NearEarthObjectUI(
    val id: String,
    val name: String,
    val nasaJplUrl: String,
   // val absoluteMagnitude: Float? = null,
    val estimatedDiameter: NeoEstimatedDiameterUI,
    val isPotentiallyHazardousAsteroid: Boolean,
    val closeApproachData: List<NeoCloseApproachDataUI>?,
    var isFavorite: Boolean = false,
  //  val orbitalData: NeoOrbitalData? = null,
  //  val meters: NeoDiameterRange
) : Parcelable

@Parcelize
data class NeoEstimatedDiameterUI  (
    val meters: NeoDiameterRangeUI
) : Parcelable

@Parcelize
data class NeoDiameterRangeUI(
    val minimumDiameter: Int? = null,
    val maximumDiameter: Int? = null,
) : Parcelable

@Keep
@Parcelize
data class NeoCloseApproachDataUI(
    val asteroidId: String,
    val approachDate: String? = null,
    val approachEpochDate: Long? = null,
   // val relativeVelocity: NeoRelativeVelocity? = null,
  //  val missDistance: NeoMissDistance? = null,
) : Parcelable

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

