package it.ttdc.pub.data.remote

import it.ttdc.pub.domain.model.Pub
import it.ttdc.pub.domain.repository.PubRemoteRepository
import javax.inject.Inject
import it.ttdc.pub.data.remote.model.RemotePub


fun RemotePub.toModel(): Pub = Pub(
    id = this.id,
    type = this.type,
    lat = lat,
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


class PubRetrofitRepository @Inject constructor (
    private val pubService: PubService): PubRemoteRepository {

    override suspend fun getPubs(): List<Pub> {
        return pubService.downloadPubs()
            .map(RemotePub::toModel)

    }


    }


