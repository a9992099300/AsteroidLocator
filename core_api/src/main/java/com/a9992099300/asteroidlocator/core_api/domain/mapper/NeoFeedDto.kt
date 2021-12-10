package com.a9992099300.asteroidlocator.core_impl.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.inject.Inject


@JsonClass(generateAdapter = true)
data class NeoFeedDto(
    @Json(name = "element_count") val elementCount: Int,//+
    @Json(name = "near_earth_objects") val asteroidsByDate: Map<String, List<NearEarthObjectDto>>//+
)

@JsonClass(generateAdapter = true)
data class NearEarthObjectDto(
    @Json(name = "id") val id: String? = null,//+
    @Json(name = "name") val name: String? = null,//+
    @Json(name = "nasa_jpl_url") val nasaJplUrl: String? = null,//?
 //   @Json(name = "absolute_magnitude_h") val absoluteMagnitude: Float? = null,//?
    @Json(name = "estimated_diameter") val estimatedDiameter: NeoEstimatedDiameterDto,//+
    @Json(name = "is_potentially_hazardous_asteroid") val isPotentiallyHazardousAsteroid: Boolean? = null,//+
    @Json(name = "close_approach_data") val closeApproachData: List<NeoCloseApproachDataDto>,//+
  //  @Json(name = "orbital_data") val orbitalData: NeoOrbitalDataDto? = null,//-
)

@JsonClass(generateAdapter = true)
data class NeoEstimatedDiameterDto(
    @Json(name = "meters") val meters: NeoDiameterRangeDto //+
)

@JsonClass(generateAdapter = true)
data class NeoDiameterRangeDto(
    @Json(name = "estimated_diameter_min") val minimumDiameter: Double? = null,//+
    @Json(name = "estimated_diameter_max") val maximumDiameter: Double? = null,//+
)

@JsonClass(generateAdapter = true)
data class NeoCloseApproachDataDto(
    @Json(name = "close_approach_date") val approachDate: String? = null,//+
    @Json(name = "epoch_date_close_approach") val approachEpochDate: Long? = null,//-
//    @Json(name = "relative_velocity") val relativeVelocity: NeoRelativeVelocityDto? = null,//+
  //  @Json(name = "miss_distance") val missDistance: NeoMissDistanceDto? = null,//+
)

//@JsonClass(generateAdapter = true)
//data class NeoRelativeVelocityDto(
//    @Json(name = "kilometers_per_second") val kilometersPerSecond: Double? = null//+
//)
//
//@JsonClass(generateAdapter = true)
//data class NeoMissDistanceDto(
//    @Json(name = "kilometers") val kilometers: Double? = null,//+
//    @Json(name = "lunar") val lunar: Double? = null,//+
//)

//@JsonClass(generateAdapter = true)
//data class NeoOrbitalDataDto(
//    @Json(name = "orbit_class") val orbitClass: NeoOrbitClassDto? = null//-
//)

//@JsonClass(generateAdapter = true)
//data class NeoOrbitClassDto(
//    @Json(name = "orbit_class_description") val description: String? = null//-
//)