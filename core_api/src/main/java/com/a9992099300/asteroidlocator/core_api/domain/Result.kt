package com.a9992099300.asteroidlocator.core_api.domain

sealed class Result<out T> {

    data class Success<out T>(val value: T) : Result<T>()

    open class Error(val error: Throwable? = null) : Result<Nothing>()

    object ConnectionError : Error()

    object Loading : Result<Nothing>()

    object Empty : Result<Nothing>()
}
