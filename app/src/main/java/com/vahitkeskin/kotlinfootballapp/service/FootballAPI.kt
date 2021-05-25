package com.vahitkeskin.kotlinfootballapp.service

import com.vahitkeskin.kotlinfootballapp.model.Model
import com.vahitkeskin.kotlinfootballapp.util.Constants.Companion.API_GET_URL
import io.reactivex.Single
import retrofit2.http.GET

interface FootballAPI {

    @GET(API_GET_URL)
    fun getFootballData(): Single<List<Model>>

}