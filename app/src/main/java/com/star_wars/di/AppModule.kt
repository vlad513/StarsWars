package com.star_wars.di

import com.star_wars.presentation.menu.favorite.FavoriteViewModel
import com.star_wars.presentation.menu.main.MainViewModel
import com.star_wars.presentation.more.MoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getPeoplesUseCase = get(),
            addFavoriteUseCase = get()
        )
    }
    viewModel<FavoriteViewModel> {
        FavoriteViewModel(
            getDatabaseUseCase = get(),
            deleteDatabaseUseCase = get()
        )
    }
    viewModel<MoreViewModel> {
        MoreViewModel(
            getPlanetsUseCase = get()
        )
    }
}