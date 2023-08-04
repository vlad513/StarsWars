package com.star_wars.domain.usecase

import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.repository.RepositoryFavorite
import com.star_wars.domain.repository.RepositoryMain

class GetDatabaseUseCase(private val repositoryFavorite: RepositoryFavorite) {
    suspend fun execute(): List<ModelDomainFavorite>? {
        return repositoryFavorite.getAllPeoplesDatabase()
    }
}