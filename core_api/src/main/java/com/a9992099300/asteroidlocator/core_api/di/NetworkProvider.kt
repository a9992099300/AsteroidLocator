package com.a9992099300.asteroidlocator.core_api.di

import com.a9992099300.asteroidlocator.core_api.domain.mapper.ModelMapper
import com.a9992099300.asteroidlocator.core_impl.dto.*
import com.a9992099300.asteroidsneo.data.*
import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit(): Retrofit

}