package it.ttdc.pub.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pubs")
class LocalPub (
    @PrimaryKey
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
    @ColumnInfo(name = "opening_hours") //convention on database
    val openingHours: String?,

    // Extra opzionali
    val phone: String?,
    val email: String?,
    val website: String?,
    val facebook: String?,
    val vatin: String?,
    val operator: String?,
    @ColumnInfo(name = "check_date") //convention on database
    val checkDate: String?,
    val smoking: String?

)