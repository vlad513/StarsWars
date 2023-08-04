package com.star_wars.domain.usecase

import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.repository.RepositoryFavorite

class DeleteDatabaseUseCase(private val repositoryFavorite: RepositoryFavorite) {
    suspend fun execute(peoples: ModelDomainFavorite) {
        repositoryFavorite.deleteFavoriteDatabase(peoples = peoples)
    }
}