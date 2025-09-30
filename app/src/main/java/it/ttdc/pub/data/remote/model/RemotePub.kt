package it.ttdc.pub.data.remote.model

data class RemotePub(
    val id: Int,
    val nome_location: String,
    val luogo: String,
    val provincia: String,
    val citta: String,
    val codice_postale: Int,
    val latitudine: Double,
    val longitudine: Double,

    val categoria: String,
    val descrizione: String?,
    val orario_apertura: String,
    val orario_chiusura: String,
    val aperto_adesso: Boolean,
    val valutazione_media: Double,
    val numero_recensioni: Int,
    val stato_affollamento: String,

    val telefono: String?,
    val email: String?,

    val eventi_in_programma: List<String>?,

    val fascia_prezzo: String,
    val accetta_prenotazioni: Boolean
)
