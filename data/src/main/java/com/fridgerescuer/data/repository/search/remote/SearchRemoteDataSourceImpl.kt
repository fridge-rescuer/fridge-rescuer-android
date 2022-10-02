package com.fridgerescuer.data.repository.search.remote

import com.fridgerescuer.data.api.ApiInterface
import com.fridgerescuer.data.model.search.IngrListResponse
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRemoteDataSourceImpl @Inject constructor(
    private val apiInterFace: ApiInterface
): SearchRemoteDataSource {

    override fun getIngrList(query: String, display: Int?): Single<IngrListResponse> {
        return apiInterFace.getIngrList(query, display)
    }

}