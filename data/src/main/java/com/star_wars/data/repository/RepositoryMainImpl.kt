package com.star_wars.data.repository

import com.star_wars.data.remote.retrofit.RetrofitCreateRequest
import com.star_wars.data.storage.room.Dao
import com.star_wars.data.utils.mapToDatabase
import com.star_wars.data.utils.mapToDomain
import com.star_wars.domain.Result
import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.repository.RepositoryMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryMainImpl(
    private val retrofitCreateRequest: RetrofitCreateRequest,
    private val dao: Dao
) :
    RepositoryMain {
    override suspend fun getAllPeoples(query: String): Result<ModelDomainAllPeoples?> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(
                    retrofitCreateRequest.create.getAllPeoples(query).body()
                        ?.let { mapToDomain(it) })
            } catch (e: java.lang.Exception) {
                Result.Error(Exception("Error"))
            }
        }
    }

    override suspend fun addPeoplesDatabase(peoples: ModelDomainResults) {
        dao.addPeoples(mapToDatabase(peoples = peoples))
    }

}