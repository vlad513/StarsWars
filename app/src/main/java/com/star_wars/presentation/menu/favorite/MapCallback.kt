package com.star_wars.presentation.menu.favorite.adapter

import com.star_wars.domain.models.ModelDomainAllPeoples
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.presentation.menu.favorite.FavoriteFragment
import com.star_wars.presentation.menu.main.adapter.FavoriteAdapter

fun FavoriteFragment.mapToCallback(peoples: ModelDomainFavorite): ModelDomainResults {
    return ModelDomainResults(
        name = peoples.name,
        height = peoples.height,
        mass = peoples.mass,
        hair_color = peoples.hair_color,
        skin_color = peoples.skin_color,
        eye_color = peoples.eye_color,
        birth_year = peoples.birth_year,
        gender = peoples.gender,
        homeworld = peoples.homeworld,
        films = emptyList(),
        species =emptyList(),
        vehicles =emptyList(),
        starships = List(peoples.starships!!.toInt()){" "},
        created = peoples.created,
        edited = peoples.edited,
        url = peoples.url
    )
}