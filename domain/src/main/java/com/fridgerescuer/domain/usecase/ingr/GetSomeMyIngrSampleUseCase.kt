package com.fridgerescuer.domain.usecase.ingr

import com.fridgerescuer.domain.model.myingr.MyIngr
import com.fridgerescuer.domain.model.myingr.MyIngrSample
import com.fridgerescuer.domain.repository.MyIngrRepository
import com.fridgerescuer.domain.model.myingr.mapperToIngrSample
import io.reactivex.rxjava3.core.Flowable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class GetSomeMyIngrSampleUseCase @Inject constructor(private val repository: MyIngrRepository) {
    operator fun invoke(): Flowable<List<MyIngrSample>> = repository.getAllMyIngrs().map { item -> mapperToIngrSample(getCloseIngr(item, 3)) }

    private fun getCloseIngr(myIngrs: List<MyIngr>, days: Long): List<MyIngr> {
        val list = mutableListOf<MyIngr>()
        val day: LocalDate = LocalDate.now().plusDays(days)

        for (ingr in myIngrs) {
            if (LocalDate.parse(ingr.exp_date, DateTimeFormatter.ISO_LOCAL_DATE) <= day)
                list.add(ingr)
        }
        return list
    }
}