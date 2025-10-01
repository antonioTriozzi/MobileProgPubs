package it.ttdc.pub.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import it.ttdc.pub.data.local.entity.LocalPub
import kotlinx.coroutines.flow.Flow

@Dao
interface PubDao {

    @Upsert
    suspend fun insert (pubs: List<LocalPub>)

    @Upsert
    suspend fun insert (pubs: LocalPub)

    @Query("SELECT * FROM pubs ORDER BY city" )
    fun getAllPubs(): Flow<List<LocalPub>> //ritorna una lista di pubs

    @Query("Delete FROM pubs")
    suspend fun deleteAll() // non ritorna, niente Flow
}