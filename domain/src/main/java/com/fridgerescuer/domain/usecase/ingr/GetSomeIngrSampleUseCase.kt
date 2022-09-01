package com.fridgerescuer.domain.usecase.ingr

import com.fridgerescuer.domain.model.ingr.IngrSample
import com.fridgerescuer.domain.repository.IngrRepository
import com.fridgerescuer.domain.model.ingr.mapperToIngrSample
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class GetSomeIngrSampleUseCase @Inject constructor(private val repository: IngrRepository) {
    operator fun invoke(): Flowable<List<IngrSample>> = repository.getAllIngrs().map { item -> mapperToIngrSample(item) }
}