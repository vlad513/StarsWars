package com.star_wars.data.utils

import com.star_wars.data.storage.entity.ModelEntityResults
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.repository.RepositoryFavorite

fun RepositoryFavorite.mapToDatabase(peoples: ModelDomainFavorite): ModelEntityResults {
    return ModelEntityResults(
        id = peoples.id,
        name = peoples.name,
        height = peoples.height,
        mass = peoples.mass,
        hair_color = peoples.hair_color,
        skin_color = peoples.skin_color,
        eye_color = peoples.eye_color,
        birth_year = peoples.birth_year,
        gender = peoples.gender,
        homeworld = peoples.homeworld,
        starships = peoples.starships,
        created = peoples.created,
        edited = peoples.edited,
        url = peoples.url
    )
}