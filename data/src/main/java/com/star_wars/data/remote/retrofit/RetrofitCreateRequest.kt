package com.star_wars.data.remote.retrofit

import com.star_wars.data.remote.ApiService


class RetrofitCreateRequest (val retrofitBuilder: RetrofitBuilder) {

    val create = retrofitBuilder.retrofit.create(ApiService::class.java)
}