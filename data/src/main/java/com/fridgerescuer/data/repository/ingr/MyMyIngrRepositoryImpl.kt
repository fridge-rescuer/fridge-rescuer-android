package com.fridgerescuer.data.repository.ingr

import com.fridgerescuer.data.mapper.mapperToIngrs
import com.fridgerescuer.data.mapper.mapperToIngrEntity
import com.fridgerescuer.data.repository.ingr.local.MyIngrLocalDataSource
import com.fridgerescuer.domain.model.myingr.MyIngr
import com.fridgerescuer.domain.repository.MyIngrRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyMyIngrRepositoryImpl @Inject constructor(
    private val myIngrLocalDataSource: MyIngrLocalDataSource
): MyIngrRepository {

    override fun insertMyIngr(myIngr: MyIngr): Completable {
        return myIngrLocalDataSource.insertIngr(mapperToIngrEntity(myIngr))
    }

    override fun getMyIngr(): Flowable<MyIngr> {
        TODO("Not yet implemented")
    }

    override fun getAllMyIngrs(): Flowable<List<MyIngr>> {
        return myIngrLocalDataSource.getAllIngrs()
            .onErrorReturn { listOf() }
            .flatMapPublisher { myIngrs ->
                Flowable.just(mapperToIngrs(myIngrs)) }
    }
}