package com.star_wars.domain.usecase

import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.repository.RepositoryMain

class AddFavoriteUseCase(private val repositoryMain: RepositoryMain) {
    suspend fun execute(peoples: ModelDomainResults) {
        repositoryMain.addPeoplesDatabase(peoples = peoples)
    }
}