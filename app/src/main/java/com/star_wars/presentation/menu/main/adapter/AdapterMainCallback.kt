package com.star_wars.presentation.menu.main.adapter

import com.star_wars.domain.models.ModelDomainResults


interface AdapterMainCallback {

    fun favorite(peoples:ModelDomainResults)
    fun send(peoples:ModelDomainResults)

}