package com.star_wars.data.utils

import com.star_wars.data.storage.entity.ModelEntityResults
import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.repository.RepositoryMain

fun RepositoryMain.mapToDatabase(peoples: ModelDomainResults): ModelEntityResults {
    return ModelEntityResults(
        id=0,
        name = peoples.name,
        height = peoples.height,
        mass = peoples.mass,
        hair_color = peoples.hair_color,
        skin_color = peoples.skin_color,
        eye_color = peoples.eye_color,
        birth_year = peoples.birth_year,
        gender = peoples.gender,
        homeworld = peoples.homeworld,
        starships = peoples.starships.count().toString(),
        created = peoples.created,
        edited = peoples.edited,
        url = peoples.url
    )
}