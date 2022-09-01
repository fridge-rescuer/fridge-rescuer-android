package com.fridgerescuer.data.repository.ingr.local

import com.fridgerescuer.data.db.myingr.MyIngrDao
import com.fridgerescuer.data.model.ingr.IngrEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngrLocalDataSourceImpl @Inject constructor(
    private val myIngrDao: MyIngrDao
): IngrLocalDataSource {

    override fun getIngr() {
        TODO("Not yet implemented")
    }

    override fun getAllIngrs(): Single<List<IngrEntity>> = myIngrDao.getAll()
}