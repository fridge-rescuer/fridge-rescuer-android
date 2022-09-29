package com.fridgerescuer.domain.repository

import com.fridgerescuer.domain.model.myingr.MyIngr
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface MyIngrRepository {
    fun insertMyIngr(myIngr: MyIngr): Completable
    fun getMyIngr(): Flowable<MyIngr>
    fun getAllMyIngrs(): Flowable<List<MyIngr>>
}