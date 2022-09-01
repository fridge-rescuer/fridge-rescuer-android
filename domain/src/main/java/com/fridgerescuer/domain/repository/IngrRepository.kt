package com.fridgerescuer.domain.repository

import com.fridgerescuer.domain.model.ingr.Ingr
import io.reactivex.rxjava3.core.Flowable

interface IngrRepository {
    fun getIngr(): Flowable<Ingr>
    fun getAllIngrs(): Flowable<List<Ingr>>
}