package com.fridgerescuer.data.repository.search.remote

import com.fridgerescuer.data.model.search.IngrListResponse
import io.reactivex.rxjava3.core.Single

interface SearchRemoteDataSource {
    fun getIngrList(
        query: String,
        display: Int?
    ): Single<IngrListResponse>
}