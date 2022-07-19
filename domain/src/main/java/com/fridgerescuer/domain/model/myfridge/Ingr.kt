package com.fridgerescuer.domain.model.myfridge

data class Ingr(
    val id: Int,
    val ingr_name: String,
    val exp_date: String,
    val storage: Int,
    val use_date: Int?
)
