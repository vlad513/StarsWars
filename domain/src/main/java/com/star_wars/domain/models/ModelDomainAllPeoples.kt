package com.star_wars.domain.models

data class ModelDomainAllPeoples(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<ModelDomainResults?>
)



