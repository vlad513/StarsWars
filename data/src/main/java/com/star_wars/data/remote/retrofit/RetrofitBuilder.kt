package com.star_wars.data.remote.retrofit

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder {
    private val moshi = com.squareup.moshi.Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(
        HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        )).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()
}