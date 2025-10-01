package it.ttdc.pub.data.remote

import it.ttdc.pub.common.API_DATA
import it.ttdc.pub.data.remote.model.RemotePub
import it.ttdc.pub.domain.model.Pub
import retrofit2.http.GET

interface PubService {

    @GET(API_DATA)
    suspend fun downloadPubs(): List<RemotePub>
}