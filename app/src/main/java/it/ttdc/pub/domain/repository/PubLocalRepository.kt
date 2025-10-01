package it.ttdc.pub.domain.repository

import it.ttdc.pub.domain.model.Pub
import kotlinx.coroutines.flow.Flow

interface PubLocalRepository {

    suspend fun insertPubs(pubs: List<Pub>)

    suspend fun insertPub(pub: Pub)

    suspend fun getAllPubs(): Flow<List<Pub>>

    suspend fun deleteAll()
}