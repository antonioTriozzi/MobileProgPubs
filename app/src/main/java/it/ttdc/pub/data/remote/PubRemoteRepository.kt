package it.ttdc.pub.data.remote

import it.ttdc.pub.domain.model.Pub

interface PubRemoteRepository {

    suspend fun getPubs(): List<Pub>
}