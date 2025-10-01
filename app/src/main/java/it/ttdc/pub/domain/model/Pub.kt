package it.ttdc.pub.domain.model

data class Pub(
    val id: Long,
    val type: String,
    val lat: Double,
    val lon: Double,
    val name: String?,
    val amenity: String?,
    val street: String?,
    val housenumber: String?,
    val city: String?,
    val postcode: String?,
    val openingHours: String?,
    val phone: String?,
    val email: String?,
    val website: String?,
    val facebook: String?,
    val vatin: String?,
    val operator: String?,
    val checkDate: String?,
    val smoking: String?
)
