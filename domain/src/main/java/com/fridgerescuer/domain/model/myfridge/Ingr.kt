package com.fridgerescuer.domain.model.myfridge

data class Ingr(
    val id: Short,
    val ingr_name: String,
    val exp_date: String,
    val storage: Int,
    val use_date: String?
)
