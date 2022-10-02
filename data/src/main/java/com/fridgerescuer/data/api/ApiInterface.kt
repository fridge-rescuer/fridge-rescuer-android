package com.fridgerescuer.data.api

import com.fridgerescuer.data.model.search.IngrListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v1/getIngrList")
    fun getIngrList(
        @Query("query") query:String,
        @Query("display") display: Int? = 10
    ): Single<IngrListResponse>
}