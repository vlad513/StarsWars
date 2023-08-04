package com.star_wars.domain.repository

import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainFavorite

interface RepositoryFavorite {
    suspend fun getAllPeoplesDatabase(): List<ModelDomainFavorite>?
    suspend fun deleteFavoriteDatabase(peoples:ModelDomainFavorite)
}