package com.fridgerescuer.domain.repository

import io.reactivex.rxjava3.core.Single

interface SearchRepository {
    fun getIngrList(query: String, display: Int?): Single<List<String>>
}