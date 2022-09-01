package com.fridgerescuer.data.repository.ingr

import com.fridgerescuer.data.mapper.mapperToIngr
import com.fridgerescuer.data.model.ingr.IngrEntity
import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSource
import com.fridgerescuer.domain.model.ingr.Ingr
import com.fridgerescuer.domain.repository.IngrRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngrRepositoryImpl @Inject constructor(
    private val ingrLocalDataSource: IngrLocalDataSource
): IngrRepository {

    override fun getIngr(): Flowable<Ingr> {
        TODO("Not yet implemented")
    }

    override fun getAllIngrs(): Flowable<List<Ingr>> {
        return ingrLocalDataSource.getAllIngrs()
            .onErrorReturn { listOf() }
            .flatMapPublisher { localIngrs ->
                Flowable.just(mapperToIngr(localIngrs)) }
    }
}