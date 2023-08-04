package com.star_wars.data.utils

import com.star_wars.data.remote.models.ModelDataPlanet
import com.star_wars.domain.models.ModelDomainPlanet
import com.star_wars.domain.repository.RepositoryMore

fun RepositoryMore.mapToDomain(planet: ModelDataPlanet): ModelDomainPlanet {
    return ModelDomainPlanet(
        name = planet.name,
        rotation_period = planet.rotation_period,
        orbital_period = planet.orbital_period,
        diameter = planet.diameter,
        climate = planet.climate,
        gravity = planet.gravity,
        terrain = planet.terrain,
        surface_water = planet.surface_water,
        population = planet.population,
        residents = planet.residents,
        films = planet.films,
        created = planet.created,
        edited = planet.edited,
        url = planet.url
    )
}