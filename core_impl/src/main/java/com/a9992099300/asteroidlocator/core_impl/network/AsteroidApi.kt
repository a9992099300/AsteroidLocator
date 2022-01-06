package com.a9992099300.asteroidlocator.core_impl.network



import com.a9992099300.asteroidlocator.core_impl.dto.NeoFeedDto
import com.a9992099300.asteroidsneo.data.NeoFeed
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidApi {
    @GET("neo/rest/v1/feed?"
    )
    suspend fun loadAsteroid(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): NeoFeedDto
}
