package com.fridgerescuer.data.mapper

import com.fridgerescuer.data.model.myingr.MyIngrEntity
import com.fridgerescuer.domain.model.myingr.MyIngr

fun mapperToIngr(ingr: MyIngrEntity): MyIngr {
    return MyIngr(
        ingr.id,
        ingr.ingr_id,
        ingr.ingr_name,
        ingr.exp_date,
        ingr.storage,
        ingr.ingr_image,
        ingr.buy_date,
        ingr.use_date
    )
}

fun mapperToIngrEntity(myIngr: MyIngr): MyIngrEntity {
    return MyIngrEntity(
        myIngr.id,
        myIngr.ingr_id,
        myIngr.ingr_name,
        myIngr.exp_date,
        myIngr.storage,
        myIngr.ingr_image,
        myIngr.buy_date,
        myIngr.use_date
    )
}

fun mapperToIngrs(ingrs: List<MyIngrEntity>): List<MyIngr> {
    return ingrs.toList().map {
        MyIngr(
            it.id,
            it.ingr_id,
            it.ingr_name,
            it.exp_date,
            it.storage,
            it.ingr_image,
            it.buy_date,
            it.use_date
        )
    }
}

fun mapperToIngrEntities(myIngrs: List<MyIngr>): List<MyIngrEntity> {
    return myIngrs.toList().map {
        MyIngrEntity(
            it.id,
            it.ingr_id,
            it.ingr_name,
            it.exp_date,
            it.storage,
            it.ingr_image,
            it.buy_date,
            it.use_date
        )
    }
}

//fun mapperToIngrEntity(ingrs: List<Ingr>): List<IngrEntity>