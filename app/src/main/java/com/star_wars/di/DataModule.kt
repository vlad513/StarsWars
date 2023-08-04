package com.star_wars.di

import androidx.room.Room
import com.star_wars.data.remote.retrofit.RetrofitBuilder
import com.star_wars.data.remote.retrofit.RetrofitCreateRequest
import com.star_wars.data.repository.RepositoryFavoriteImpl
import com.star_wars.data.repository.RepositoryMainImpl
import com.star_wars.data.repository.RepositoryMoreImpl
import com.star_wars.data.storage.room.Dao
import com.star_wars.data.storage.room.RunDatabase
import com.star_wars.domain.repository.RepositoryFavorite
import com.star_wars.domain.repository.RepositoryMain
import com.star_wars.domain.repository.RepositoryMore
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val dataModule = module {
    // Room Database instance
    single<RunDatabase> {
        Room.databaseBuilder(
            androidApplication(), RunDatabase::class.java, "database"
        ).build()
    }
    single<Dao> {
        val database = get<RunDatabase>()
        database.getRunDao()
    }
    single<RepositoryMain> {
        RepositoryMainImpl(
            retrofitCreateRequest = get(),
            dao = get()
        )
    }
    single<RepositoryFavorite> {
        RepositoryFavoriteImpl(dao = get())
    }
    single<RepositoryMore> {
        RepositoryMoreImpl(retrofitCreateRequest = get())
    }
    single<RetrofitBuilder> {
        RetrofitBuilder()
    }
    single<RetrofitCreateRequest> {
        RetrofitCreateRequest(retrofitBuilder = get())
    }
}