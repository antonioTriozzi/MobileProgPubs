package it.ttdc.pub.data.local

import it.ttdc.pub.data.local.dao.PubDao
import it.ttdc.pub.data.local.entity.LocalPub
import it.ttdc.pub.domain.model.Pub
import it.ttdc.pub.domain.repository.PubLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


fun LocalPub.toModel(): Pub = Pub(
    id = this.id,
    type = this.type,
    lat = this.lat,
    lon = this.lon,
    name = this.name,

    amenity = this.amenity,
    street = this.street,
    housenumber = this.housenumber,
    city = this.city,
    postcode = this.postcode,
    openingHours = this.openingHours,
    phone = this.phone,
    email = this.email,
    website = this.website,
    facebook = this.facebook,
    vatin = this.vatin,
    operator = this.operator,
    checkDate = this.checkDate,

    smoking = this.smoking
)
fun Pub.toLocal(): LocalPub = LocalPub(

    id = this.id,
    type = this.type,
    lat = this.lat,
    lon = this.lon,
    name = this.name,
    amenity = this.amenity,
    street = this.street,
    housenumber = this.housenumber,
    city = this.city,
    postcode = this.postcode,
    openingHours = this.openingHours,
    phone = this.phone,
    email = this.email,
    website = this.website,
    facebook = this.facebook,
    vatin = this.vatin,
    operator = this.operator,
    checkDate = this.checkDate,
    smoking = this.smoking


)









class PubRoomRepository @Inject constructor(
    private val pubDao: PubDao
): PubLocalRepository {

    override suspend fun insertPubs(pubs: List<Pub>) {
        TODO("Not yet implemented")

    }
    override suspend fun insertPub(pub: Pub) {
        pubDao.insert(pub.toLocal())
    }
    override suspend fun getAllPubs(): Flow< List<Pub>> {
        return pubDao.getAllPubs()
            .map { list -> list.map (LocalPub::toModel)}
    }
    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }
}