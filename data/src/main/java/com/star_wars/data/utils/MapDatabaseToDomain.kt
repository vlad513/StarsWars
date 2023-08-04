package com.star_wars.data.utils

import com.star_wars.data.storage.entity.ModelEntityResults
import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.repository.RepositoryFavorite

fun RepositoryFavorite.mapToDomain(peoples: List<ModelEntityResults>): List<ModelDomainFavorite> {
    val list = arrayListOf<ModelDomainFavorite>()
    peoples.forEach { it ->
        list.add(
            ModelDomainFavorite(
                id = it.id,
                name = it.name,
                height = it.height,
                mass = it.mass,
                hair_color = it.hair_color,
                skin_color = it.skin_color,
                eye_color = it.eye_color,
                birth_year = it.birth_year,
                gender = it.gender,
                homeworld = it.homeworld,
                starships = it.starships,
                created = it.created,
                edited = it.edited,
                url = it.url
            )
        )
    }
return list
}