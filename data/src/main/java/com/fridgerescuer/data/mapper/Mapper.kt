package com.fridgerescuer.data.mapper

import com.fridgerescuer.data.model.myfridge.IngrEntity
import com.fridgerescuer.domain.model.myfridge.Ingr

fun mapperToIngrs(ingrs: List<IngrEntity>): List<Ingr> {
    return ingrs.toList().map {
        Ingr(
            it.id,
            it.ingr_name,
            it.exp_date,
            it.storage,
            it.use_date,
        )
    }
}

//fun mapperToIngrEntity(ingrs: List<Ingr>): List<IngrEntity>