package com.fridgerescuer.data.repository.myingr.local

import com.fridgerescuer.data.model.myingr.MyIngrEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface MyIngrLocalDataSource {
    fun insertIngr(entity: MyIngrEntity): Completable
    fun getIngr()
    fun getAllIngrs(): Single<List<MyIngrEntity>>
}