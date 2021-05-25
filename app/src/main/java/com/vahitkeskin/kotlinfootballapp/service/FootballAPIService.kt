package com.vahitkeskin.kotlinfootballapp.service

import com.vahitkeskin.kotlinfootballapp.model.Model
import com.vahitkeskin.kotlinfootballapp.util.Constants.Companion.API_BASE_URL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FootballAPIService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(FootballAPI::class.java)

    fun getService(): Single<List<Model>> {
        return retrofit.getFootballData()
    }

}