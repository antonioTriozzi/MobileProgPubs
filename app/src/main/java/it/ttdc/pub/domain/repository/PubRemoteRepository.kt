package it.ttdc.pub.domain.repository

import it.ttdc.pub.domain.model.Pub

interface PubRemoteRepository {

    suspend fun getPubs(): List<Pub>

}