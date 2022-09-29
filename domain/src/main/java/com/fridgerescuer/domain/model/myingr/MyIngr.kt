package com.fridgerescuer.domain.model.myingr

import android.graphics.Bitmap

data class MyIngr(
    val id: Int,
    val ingr_id: Short,
    val ingr_name: String,
    val exp_date: String,
    val storage: String,
    val ingr_image: Bitmap?,
    val buy_date: String?,
    val use_date: String?
)