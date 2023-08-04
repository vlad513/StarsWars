package com.star_wars.domain.repository

import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.Result

interface RepositoryMain {
    suspend fun getAllPeoples(query: String): Result<ModelDomainAllPeoples?>
    suspend fun addPeoplesDatabase(peoples: ModelDomainResults)
}