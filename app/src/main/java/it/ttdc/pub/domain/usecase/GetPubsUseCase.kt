package it.ttdc.pub.domain.usecase

import androidx.compose.foundation.layout.FlowRow
import it.ttdc.pub.common.Resource
import it.ttdc.pub.domain.model.Pub
import it.ttdc.pub.domain.repository.PubLocalRepository
import it.ttdc.pub.domain.repository.PubRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPubsUseCase @Inject constructor(
    private val remoteRepo: PubRemoteRepository,
    private val localRepo: PubLocalRepository

) {

    operator fun invoke() : Flow<Resource<List<Pub>>> {
        return flow {
            emit(Resource.Loading("Loading..."))
            localRepo.getAllPubs()
                .catch {
                    emit(Resource.Error("Error"))}
        .collect { list ->
            if(list.isEmpty()) {
                //remoteRequest
                try{

                val data = remoteRepo.getPubs()
                localRepo.insertPubs(data)
                emit(Resource.Success(data))

                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error("Error"))
                }

            } else {
                //local request
                emit(Resource.Success(list))
            }
        }


        }
    }



}
