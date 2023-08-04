package com.star_wars.domain.usecase

import com.star_wars.domain.Result
import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.repository.RepositoryMain

class GetPeoplesUseCase(private val repositoryMain: RepositoryMain) {
    suspend fun execute(query: String): Result<ModelDomainAllPeoples?> {
        return repositoryMain.getAllPeoples(query = query)
    }
}