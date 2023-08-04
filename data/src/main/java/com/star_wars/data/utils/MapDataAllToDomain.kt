package com.star_wars.data.utils

import com.star_wars.data.remote.models.ModelDataAllPeoples
import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.domain.repository.RepositoryMain

fun RepositoryMain.mapToDomain(data: ModelDataAllPeoples): ModelDomainAllPeoples {
    val list = arrayListOf<ModelDomainResults>()
    data.results.forEach { it ->
        if (it != null) {
            list.add(
                ModelDomainResults(
                    name = it.name,
                    height = it.height,
                    mass = it.mass,
                    hair_color = it.hair_color,
                    skin_color = it.skin_color,
                    eye_color = it.eye_color,
                    birth_year = it.birth_year,
                    gender = it.gender,
                    homeworld = it.homeworld,
                    films = it.films,
                    species = it.species,
                    vehicles = it.vehicles,
                    starships = it.starships,
                    created = it.created,
                    edited = it.edited,
                    url = it.url
                )
            )
        }
    }
    return ModelDomainAllPeoples(
        count = data.count,
        next = data.next,
        previous = data.previous,
        results = list
    )
}