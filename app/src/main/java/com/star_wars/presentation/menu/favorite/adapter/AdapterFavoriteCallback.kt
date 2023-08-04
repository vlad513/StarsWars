package com.star_wars.presentation.menu.main.adapter

import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.domain.models.ModelDomainResults


interface AdapterFavoriteCallback {
    fun delete(peoples: ModelDomainFavorite, position: Int)

    fun send(peoples: ModelDomainFavorite)

}