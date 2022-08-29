package com.fridgerescuer.domain.usecase.ingr

import com.fridgerescuer.domain.model.ingr.IngrSample
import com.fridgerescuer.domain.repository.IngrRepository
import com.fridgerescuer.domain.model.ingr.mapperToIngrSample
import io.reactivex.Flowable
import javax.inject.Inject

class GetSomeIngrSampleUseCase @Inject constructor(private val repository: IngrRepository) {

    operator fun invoke(): Flowable<List<IngrSample>> = repository.getCloseIngr().map { item -> mapperToIngrSample(item) }
}