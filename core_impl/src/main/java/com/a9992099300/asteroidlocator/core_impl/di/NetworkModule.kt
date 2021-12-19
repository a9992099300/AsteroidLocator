package com.a9992099300.asteroidlocator.core_impl.di

import com.a9992099300.asteroidlocator.core_impl.adapter.AsteroidNetworkSource
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidInterceptor
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidNetworkSourceImpl
import com.a9992099300.asteroidlocator.core_impl.network.AsteroidService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

const val NEO_BASE_API_URL = "https://api.nasa.gov/"


@Module
abstract class NetworkModule {


    companion object{


    @Provides
    @Singleton
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
    @Singleton
    fun provideOkHttpClient(asteroidInterceptor: AsteroidInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(asteroidInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
                )
    }

    @Provides
    @Singleton
    fun provideAsteroidApi(retrofit: Retrofit): AsteroidService {
        return retrofit.create(AsteroidService::class.java)
    }
    }
    @Binds
    @Singleton
    abstract fun AsteroidNetworkSource(asteroidNetworkSourceImpl: AsteroidNetworkSourceImpl): AsteroidNetworkSource

}