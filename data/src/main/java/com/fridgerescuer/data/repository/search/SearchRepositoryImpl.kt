package com.fridgerescuer.data.repository.search

import com.fridgerescuer.data.repository.search.remote.SearchRemoteDataSource
import com.fridgerescuer.domain.repository.SearchRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
): SearchRepository {
    override fun getIngrList(query: String, display: Int?): Single<List<String>> {
        return searchRemoteDataSource.getIngrList(query, display)
            .flatMap { ingrListResponse ->
                Single.just(ingrListResponse.ingrList)
            }
    }
}