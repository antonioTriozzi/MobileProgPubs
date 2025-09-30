package it.ttdc.pub.domain.model

import it.ttdc.pub.common.API_DATA
import it.ttdc.pub.data.remote.model.RemotePub
import retrofit2.http.GET

interface PubService {

    @GET(API_DATA)
    suspend  fun getPubs(): List<RemotePub>



}