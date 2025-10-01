package it.ttdc.pub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import it.ttdc.pub.data.local.dao.PubDao
import it.ttdc.pub.data.local.entity.LocalPub

@Database(entities = [LocalPub::class], version = 1, exportSchema = false)
abstract class PubDatabase : RoomDatabase(){

   abstract  fun getPubDao(): PubDao


}