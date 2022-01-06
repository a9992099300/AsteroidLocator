package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_api.network.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidInterceptor
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidNetworkSourceImpl
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val NEO_BASE_API_URL = "https://api.nasa.gov/"


@Module
abstract class NetworkModule {

    companion object{
    @Provides
    @NetworkScope
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
     //   baseUrl: String,
        moshi: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NEO_BASE_API_URL)
            .addConverterFactory(moshi)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @NetworkScope
    fun provideOkHttpClient(asteroidInterceptor: AsteroidInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(asteroidInterceptor)
            .build()
    }

    @Provides
    @NetworkScope
    fun provideMoshi(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
                )
    }

    @Provides
    @NetworkScope
    fun provideAsteroidApi(retrofit: Retrofit): AsteroidApi {
        return retrofit.create(AsteroidApi::class.java)
    }
    }

    @Binds
    @NetworkScope
    abstract fun AsteroidNetworkSource(asteroidNetworkSourceImpl: AsteroidNetworkSourceImpl): AsteroidNetworkSource

}