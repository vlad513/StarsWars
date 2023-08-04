package com.star_wars.data.remote.models

data class ModelDataPlanet(

    val name: String,
val rotation_period: String,
val orbital_period: String,
val diameter: String,
val climate: String,
val gravity: String,
val terrain: String,
val surface_water: String,
val population: String,
val residents:List<String>,
val films: List<String>,
val created: String,
val edited: String,
val url: String
)