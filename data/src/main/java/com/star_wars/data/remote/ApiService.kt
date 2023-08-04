package com.star_wars.data.remote

import com.star_wars.data.remote.models.ModelDataAllPeoples
import com.star_wars.data.remote.models.ModelDataPlanet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("people/")
    suspend fun getAllPeoples(
        @Query("search") search: String
    ): Response<ModelDataAllPeoples>

    @GET("planets/{id}")
    suspend fun getPlanets(
        @Path("id") id: String
    ): Response<ModelDataPlanet>
}