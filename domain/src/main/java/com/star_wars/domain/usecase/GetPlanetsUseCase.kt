package com.star_wars.domain.usecase

import com.star_wars.domain.models.ModelDomainPlanet
import com.star_wars.domain.repository.RepositoryMore

class GetPlanetsUseCase(private val repositoryMore: RepositoryMore) {
    suspend fun execute(id:String):com.star_wars.domain.Result<ModelDomainPlanet?>{
        return repositoryMore.getPlanet(id = id)
    }
}