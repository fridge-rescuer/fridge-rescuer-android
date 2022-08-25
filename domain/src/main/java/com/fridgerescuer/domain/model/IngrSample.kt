package com.fridgerescuer.domain.model

import android.graphics.Bitmap

data class IngrSample(
    val ingr_name: String,
    val exp_date: String,
    val ingr_image: Bitmap?,
    val buy_date: String,
    val use_date: Int?
)
