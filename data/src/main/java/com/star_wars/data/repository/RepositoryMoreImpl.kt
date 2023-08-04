package com.star_wars.data.repository

import com.star_wars.data.remote.retrofit.RetrofitCreateRequest
import com.star_wars.data.utils.mapToDomain
import com.star_wars.domain.Result
import com.star_wars.domain.models.ModelDomainPlanet
import com.star_wars.domain.repository.RepositoryMore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryMoreImpl(private val retrofitCreateRequest: RetrofitCreateRequest):RepositoryMore {
    override suspend fun getPlanet(id:String): Result<ModelDomainPlanet?> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(
                    retrofitCreateRequest.create.getPlanets(id = id).body()?.let { mapToDomain(it) })
            } catch (e: java.lang.Exception) {
                Result.Error(Exception("Error"))
            }
        }







    }
}