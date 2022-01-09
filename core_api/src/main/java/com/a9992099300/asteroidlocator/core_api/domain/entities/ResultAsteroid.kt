package com.a9992099300.asteroidlocator.core_api.domain

sealed class ResultAsteroid<out T> {

    data class Success<out T>(val value: T) : ResultAsteroid<T>()

    open class Error(val error: Throwable? = null) : ResultAsteroid<Nothing>()

    object Loading : ResultAsteroid<Nothing>()

    object Empty : ResultAsteroid<Nothing>()
}
