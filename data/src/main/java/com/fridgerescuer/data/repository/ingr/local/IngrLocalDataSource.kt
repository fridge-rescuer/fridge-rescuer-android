package com.fridgerescuer.data.repository.ingr.local

import com.fridgerescuer.data.model.ingr.IngrEntity
import io.reactivex.rxjava3.core.Single

interface IngrLocalDataSource {
    fun getIngr()
    fun getAllIngrs(): Single<List<IngrEntity>>
}