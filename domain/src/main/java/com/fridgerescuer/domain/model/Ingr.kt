package com.fridgerescuer.domain.model

import android.graphics.Bitmap

data class Ingr(
    val ingr_name: String,
    val exp_date: String,
    val storage: Int,
    val ingr_image: Bitmap?,
    val buy_date: String,
    val use_date: Int?,
    val qty: Int?,
    val cnt_unit: String?,
    val kcal: Int?,
    val ingr_like: Boolean,
    val store_image: Bitmap?,
    val store_str: String?
)