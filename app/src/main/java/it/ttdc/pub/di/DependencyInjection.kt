package it.ttdc.pub.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dagger.hilt.components.SingletonComponent
import it.ttdc.pub.common.BASE_URL
import it.ttdc.pub.data.local.PubDatabase
import it.ttdc.pub.data.local.PubRoomRepository
import it.ttdc.pub.data.remote.PubRetrofitRepository
import it.ttdc.pub.domain.repository.PubRemoteRepository
import it.ttdc.pub.data.remote.PubService
import it.ttdc.pub.domain.repository.PubLocalRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun pubService(retrofit: Retrofit) : PubService =
        retrofit.create(PubService::class.java)


}
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun remoteRepository(repository: PubRetrofitRepository): PubRemoteRepository

    @Binds
    @Singleton
    abstract fun localRepository(repository: PubRoomRepository): PubLocalRepository


}
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{

    @Provides
    @Singleton
    fun database(@ApplicationContext context: Context): PubDatabase =
        Room.databaseBuilder(
            context,
            PubDatabase::class.java,
            "pubs.database"
        ).build()

    @Provides
    @Singleton
    fun pubDao(database: PubDatabase) = database.getPubDao()
}