package com.fridgerescuer.data.repository.myingr.local

import com.fridgerescuer.data.db.myingr.MyIngrDao
import com.fridgerescuer.data.model.myingr.MyIngrEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyIngrLocalDataSourceImpl @Inject constructor(
    private val myIngrDao: MyIngrDao
): MyIngrLocalDataSource {
    override fun insertIngr(entity: MyIngrEntity): Completable = myIngrDao.insertIngr(entity)

    override fun getIngr() {
        TODO("Not yet implemented")
    }

    override fun getAllIngrs(): Single<List<MyIngrEntity>> = myIngrDao.getAll()
}