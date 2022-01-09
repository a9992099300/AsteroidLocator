package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_impl.network.AsteroidInterceptor
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val NEO_BASE_API_URL = "https://api.nasa.gov/"


@Module
internal class NetworkModule {

    @Provides
    @Reusable
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NEO_BASE_API_URL)
            .addConverterFactory(moshi)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Reusable
    fun provideOkHttpClient(asteroidInterceptor: AsteroidInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(asteroidInterceptor)
            .build()
    }

    @Provides
    @Reusable
    fun provideMoshi(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
                )
    }

    @Provides
    @Reusable
    fun provideAsteroidApi(retrofit: Retrofit): AsteroidApi {
        return retrofit.create(AsteroidApi::class.java)
    }


}