package com.a9992099300.asteroidlocator.core_impl.network


import dagger.Reusable
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

private const val API_KEY = "pro6YLEqHTodfb3bpEhOdh3LIqN0MsJKJIlMwPdd" //presentation api key
private const val API_KEY_HEADER = "api_key"

@Reusable
internal class AsteroidInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val newUrl: HttpUrl = originalRequest.url().newBuilder()
                .addQueryParameter(API_KEY_HEADER, API_KEY)
                .build()
        val newRequest: Request = originalRequest.newBuilder()
                .url(newUrl)
                .build()
        return chain.proceed(newRequest)
    }

}