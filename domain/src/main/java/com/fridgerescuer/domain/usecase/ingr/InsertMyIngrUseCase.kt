package com.fridgerescuer.domain.usecase.ingr

import com.fridgerescuer.domain.model.myingr.MyIngr
import com.fridgerescuer.domain.repository.MyIngrRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class InsertMyIngrUseCase @Inject constructor(private val repository: MyIngrRepository) {
    operator fun invoke(myIngr: MyIngr): Completable = repository.insertMyIngr(myIngr)
}