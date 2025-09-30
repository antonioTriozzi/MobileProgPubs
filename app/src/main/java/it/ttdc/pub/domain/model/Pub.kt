package it.ttdc.pub.domain.model

data class Pub(
    val id: Int,
    val nome_location: String,
    val provincia: String,
    val citta: String,
    val codice_postale: Int,
    val latitudine: Double,
    val longitudine: Double,

    val stato: String,

)
