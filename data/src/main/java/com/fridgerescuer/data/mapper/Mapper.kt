package com.fridgerescuer.data.mapper

import com.fridgerescuer.data.model.ingr.IngrEntity
import com.fridgerescuer.domain.model.ingr.Ingr

fun mapperToIngr(ingrs: List<IngrEntity>): List<Ingr> {
    return ingrs.toList().map {
        Ingr(
            it.id,
            it.ingr_id,
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

fun mapperToIngrEntity(ingrs: List<Ingr>): List<IngrEntity> {
    return ingrs.toList().map {
        IngrEntity(
            it.id,
            it.ingr_id,
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

//fun mapperToIngrEntity(ingrs: List<Ingr>): List<IngrEntity>