package com.a9992099300.asteroidlocator.home

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
data class Asteroid (
    val id: String,
    val name: String,
    val nasaJplUrl: String,
    val isPotentiallyHazardousAsteroid: Boolean,
    var isFavorite: Boolean = false, ) : Parcelable
