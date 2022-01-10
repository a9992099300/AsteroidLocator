package com.a9992099300.asteroidsneo.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class NeoFeedUI(
    val elementCount: Int,
    val asteroidsByDate: List<NearEarthObjectUI>
) : Parcelable{

}

@Parcelize
data class NearEarthObjectUI(
    val id: String,
    val name: String?,
    val nasaJplUrl: String?,
    val estimatedDiameter: NeoEstimatedDiameterUI,
    val isPotentiallyHazardousAsteroid: Boolean?,
    val closeApproachData: List<NeoCloseApproachDataUI>?,
    var isFavorite: Boolean = false,
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


@Parcelize
data class NeoCloseApproachDataUI(
    val asteroidId: String,
    val approachDate: String? = null,
    val approachEpochDate: Long? = null,
) : Parcelable


