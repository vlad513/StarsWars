package com.star_wars.domain.repository

import com.star_wars.domain.models.ModelDomainPlanet

interface RepositoryMore {
    suspend fun getPlanet(id:String):com.star_wars.domain.Result<ModelDomainPlanet?>
}