package com.fridgerescuer.data.mapper

import com.fridgerescuer.data.model.myfridge.IngrEntity
import com.fridgerescuer.domain.model.Ingr
import com.fridgerescuer.domain.model.IngrSample

fun mapperToIngr(ingrs: List<IngrEntity>): List<Ingr> {
    return ingrs.toList().map {
        Ingr(
            it.ingr_name,
            it.exp_date,
            it.storage,
            it.ingr_image,
            it.buy_date,
            it.use_date,
            it.qty,
            it.cnt_unit,
            it.kcal,
            it.ingr_like,
            it.store_image,
            it.store_str
        )
    }
}

fun mapperToIngrSample(ingrs: List<IngrEntity>): List<IngrSample> {
    return ingrs.toList().map {
        IngrSample(
            it.ingr_name,
            it.exp_date,
            it.ingr_image,
            it.buy_date,
            it.use_date
        )
    }
}

//fun mapperToIngrEntity(ingrs: List<Ingr>): List<IngrEntity>