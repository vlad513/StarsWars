package com.star_wars.di

import com.star_wars.domain.usecase.*
import org.koin.dsl.module


val domainModule = module {

    factory<GetPeoplesUseCase> {
        GetPeoplesUseCase(
            repositoryMain = get()
        )
    }
    factory<AddFavoriteUseCase> {
        AddFavoriteUseCase(
            repositoryMain = get()
        )
    }
    factory<GetDatabaseUseCase> {
        GetDatabaseUseCase(
            repositoryFavorite = get()
        )
    }
    factory<DeleteDatabaseUseCase> {
        DeleteDatabaseUseCase(
            repositoryFavorite = get()
        )
    }
    factory<GetPlanetsUseCase> {
        GetPlanetsUseCase(
            repositoryMore = get()
        )
    }
}