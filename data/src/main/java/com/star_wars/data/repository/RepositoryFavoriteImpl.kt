package com.star_wars.data.repository


import com.star_wars.data.storage.room.Dao
import com.star_wars.data.utils.mapToDatabase
import com.star_wars.data.utils.mapToDomain
import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.repository.RepositoryFavorite

class RepositoryFavoriteImpl(private val dao: Dao) : RepositoryFavorite {
    override suspend fun getAllPeoplesDatabase(): List<ModelDomainFavorite> {
        return mapToDomain(dao.readAllPeoples())
    }

    override suspend fun deleteFavoriteDatabase(peoples: ModelDomainFavorite) {
        dao.deletePeoples(peoples = mapToDatabase(peoples))
    }
}