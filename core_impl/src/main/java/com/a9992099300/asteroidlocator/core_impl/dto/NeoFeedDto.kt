package com.a9992099300.asteroidlocator.core_impl.dto

import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NeoFeedDto(
    @Json(name = "element_count") val elementCount: Int,//+
    @Json(name = "near_earth_objects") val asteroidsByDate: Map<String, List<NearEarthObjectDto>>//+
)

@Entity(tableName = "Asteroids")
@JsonClass(generateAdapter = true)
data class NearEarthObjectDto(
    @PrimaryKey
    @Json(name = "id") val id: String = " ",
    @Json(name = "name") val name: String,
    @Json(name = "nasa_jpl_url") val nasaJplUrl: String,
    @Json(name = "estimated_diameter") val estimatedDiameter: NeoEstimatedDiameterDto,
    @Json(name = "is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,//+
    @Ignore
    @Json(name = "close_approach_data") var closeApproachData: List<NeoCloseApproachDataDto>?,
    var isFavorite: Boolean = false,
    @Embedded
    @Json(name = "orbital_data") val orbitalData: NeoOrbitalDataDto? = null
)   {
    // Constructor for Room.
    constructor(
        id: String,
        name: String,
        nasaJplUrl: String,
        estimatedDiameter: NeoEstimatedDiameterDto,
        isPotentiallyHazardousAsteroid: Boolean,
        isFavorite: Boolean,
        orbitalData: NeoOrbitalDataDto?
    ) : this(id, name, nasaJplUrl,estimatedDiameter, isPotentiallyHazardousAsteroid,
        null, isFavorite, orbitalData)

}

@JsonClass(generateAdapter = true)
data class NeoEstimatedDiameterDto(
    @Json(name = "meters") val meters: NeoDiameterRangeDto
)

@JsonClass(generateAdapter = true)
data class NeoDiameterRangeDto(
    @PrimaryKey(autoGenerate = true)
    @Json(name = "estimated_diameter_min") val minimumDiameter: Double,
    @Json(name = "estimated_diameter_max") val maximumDiameter: Double,
)

@Entity(tableName = "NeoCloseApproachData",
    foreignKeys = [ForeignKey(
        entity = NearEarthObjectDto::class,
        parentColumns = ["id"],
        childColumns = ["asteroidId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE,
    )],
    indices = [Index("asteroidId")]
)
@JsonClass(generateAdapter = true)
data class NeoCloseApproachDataDto(
    @PrimaryKey
    val asteroidId: String = " ",
    @Json(name = "close_approach_date") val approachDate: String,
    @Json(name = "epoch_date_close_approach") val approachEpochDate: Long,
    @Embedded
    @Json(name = "relative_velocity") val relativeVelocity: NeoRelativeVelocityDto,
    @Embedded
    @Json(name = "miss_distance") val missDistance: NeoMissDistanceDto,
)

@JsonClass(generateAdapter = true)
data class NeoRelativeVelocityDto(
    @Json(name = "kilometers_per_second") val kilometersPerSecond: Double
)

@JsonClass(generateAdapter = true)
data class NeoMissDistanceDto(
    @Json(name = "kilometers") val kilometers: Double,
    @Json(name = "lunar") val lunar: Double
)

@JsonClass(generateAdapter = true)
data class NeoOrbitalDataDto(
    @Embedded
    @Json(name = "orbit_class") val orbitClass: NeoOrbitClassDto
)

@JsonClass(generateAdapter = true)
data class NeoOrbitClassDto(
    @Json(name = "orbit_class_description") val description: String?
)