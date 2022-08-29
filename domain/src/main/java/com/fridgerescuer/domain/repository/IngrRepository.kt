package com.fridgerescuer.domain.repository

import com.fridgerescuer.domain.model.ingr.Ingr
import io.reactivex.Flowable

interface IngrRepository {
    fun getCloseIngr(): Flowable<List<Ingr>>

    fun getAllIngrSample()
}