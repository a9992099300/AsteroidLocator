package com.a9992099300.asteroidlocator.core_api.network

import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit(): Retrofit
}