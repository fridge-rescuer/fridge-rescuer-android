package com.fridgerescuer.domain.usecase.search

import com.fridgerescuer.domain.repository.SearchRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetIngrListUseCase @Inject constructor(private val repository: SearchRepository) {
    operator fun invoke(query: String, display: Int?): Single<List<String>> = repository.getIngrList(query, display)
}