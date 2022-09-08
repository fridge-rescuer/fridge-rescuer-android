package com.fridgerescuer.domain.usecase.ingr

import com.fridgerescuer.domain.model.ingr.Ingr
import com.fridgerescuer.domain.model.ingr.IngrSample
import com.fridgerescuer.domain.repository.IngrRepository
import com.fridgerescuer.domain.model.ingr.mapperToIngrSample
import io.reactivex.rxjava3.core.Flowable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class GetSomeIngrSampleUseCase @Inject constructor(private val repository: IngrRepository) {
    operator fun invoke(): Flowable<List<IngrSample>> = repository.getAllIngrs().map { item -> mapperToIngrSample(getCloseIngr(item, 3)) }

    private fun getCloseIngr(ingrs: List<Ingr>, days: Long): List<Ingr> {
        val list = mutableListOf<Ingr>()
        val day: LocalDate = LocalDate.now().plusDays(days)

        for (ingr in ingrs) {
            if (LocalDate.parse(ingr.exp_date, DateTimeFormatter.ISO_LOCAL_DATE) <= day)
                list.add(ingr)
        }
        return list
    }
}