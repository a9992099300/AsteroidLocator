package com.a9992099300.asteroidlocator.home

import com.a9992099300.asteroidsneo.data.*

object ProviderFactory {

    fun getAsteroids(): NeoFeed {
        return NeoFeed(
            elementCount = 1,
            listOf(
                NearEarthObject(
                    id = "id1",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5.0,
                    maximumDiameter = 10.0,
                    isPotentiallyHazardousAsteroid = true,
                    closeApproachData = listOf(
                        NeoCloseApproachData(
                            asteroidId = "id1",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = false,
                    description = "description"
                ),
                NearEarthObject(
                    id = "id2",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5.0,
                    maximumDiameter = 10.0,
                    isPotentiallyHazardousAsteroid = false,
                    closeApproachData = listOf(
                        NeoCloseApproachData(
                            asteroidId = "id2",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = true,
                    description = "description"
                ),
                NearEarthObject(
                    id = "id3",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5.0,
                    maximumDiameter = 10.0,
                    isPotentiallyHazardousAsteroid = false,
                    closeApproachData = listOf(
                        NeoCloseApproachData(
                            asteroidId = "id3",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = false,
                    description = "description"
                )
            )
        )
    }

    fun getAsteroidsUi(): NeoFeedUI {
        return NeoFeedUI(
            elementCount = 1,
            listOf(
                NearEarthObjectUI(
                    id = "id1",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5,
                    maximumDiameter = 10,
                    isPotentiallyHazardousAsteroid = true,
                    closeApproachData = listOf(
                        NeoCloseApproachDataUI(
                            asteroidId = "id1",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = false,
                    description = "description"
                ),
                NearEarthObjectUI(
                    id = "id2",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5,
                    maximumDiameter = 10,
                    isPotentiallyHazardousAsteroid = false,
                    closeApproachData = listOf(
                        NeoCloseApproachDataUI(
                            asteroidId = "id2",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = true,
                    description = "description"
                ),
                NearEarthObjectUI(
                    id = "id3",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5,
                    maximumDiameter = 10,
                    isPotentiallyHazardousAsteroid = false,
                    closeApproachData = listOf(
                        NeoCloseApproachDataUI(
                            asteroidId = "id3",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = false,
                    description = "description"
                )
            )
        )
    }

    fun getSavedAsteroids(): NeoFeed {
        return NeoFeed(
            elementCount = 1,
            listOf(
                NearEarthObject(
                    id = "id2",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5.0,
                    maximumDiameter = 10.0,
                    isPotentiallyHazardousAsteroid = true,
                    closeApproachData = listOf(
                        NeoCloseApproachData(
                            asteroidId = "id2",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = true,
                    description = "description"
                )
            )
        )
    }

    fun getDangerousAsteroids(): NeoFeed {
        return NeoFeed(
            elementCount = 1,
            listOf(
                NearEarthObject(
                    id = "id1",
                    name = "name",
                    nasaJplUrl = "nasaJplUrl",
                    minimumDiameter = 5.0,
                    maximumDiameter = 10.0,
                    isPotentiallyHazardousAsteroid = true,
                    closeApproachData = listOf(
                        NeoCloseApproachData(
                            asteroidId = "id1",
                            approachDate = "10.10.2016",
                            approachEpochDate = 10L,
                            kilometersPerSecond = 10.0,
                            kilometers = 10.0,
                            lunar = 10.0,
                        )
                    ),
                    isFavorite = false,
                    description = "description"
                )
            )
        )
    }
}