package com.a9992099300.asteroidsneo.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class NeoFeedUI(
    val elementCount: Int,
    val asteroidsByDate: List<NearEarthObjectUI>
) : Parcelable

@Parcelize
data class NearEarthObjectUI(
    val id: String,
    val name: String,
    val nasaJplUrl: String,
    val minimumDiameter: Int,
    val maximumDiameter: Int,
    val isPotentiallyHazardousAsteroid: Boolean,
    val closeApproachData: List<NeoCloseApproachDataUI>,
    var isFavorite: Boolean = false,
    val description: String?
) : Parcelable

@Parcelize
data class NeoCloseApproachDataUI(
    val asteroidId: String,
    val approachDate: String,
    val approachEpochDate: Long,
    val kilometersPerSecond: Double,
    val kilometers: Double,
    val lunar: Double,
) : Parcelable


