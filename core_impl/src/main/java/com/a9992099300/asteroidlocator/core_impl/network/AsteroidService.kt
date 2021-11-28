package com.a9992099300.asteroidlocator.core_impl.network



import com.a9992099300.asteroidsneo.data.NeoFeed
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidService {
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroidNeo(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("detailed") detailed: Boolean = true,
    ): NeoFeed
}
