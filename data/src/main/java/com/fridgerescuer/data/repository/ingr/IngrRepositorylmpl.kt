package com.fridgerescuer.data.repository.ingr

import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSource
import com.fridgerescuer.domain.model.ingr.Ingr
import com.fridgerescuer.domain.repository.IngrRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngrRepositorylmpl @Inject constructor(
    private val ingrLocalDataSource: IngrLocalDataSource
): IngrRepository {

    override fun getCloseIngr(): Flowable<List<Ingr>> {
        TODO("Not yet implemented")
    }

    override fun getAllIngrSample() {
        TODO("Not yet implemented")
    }
}