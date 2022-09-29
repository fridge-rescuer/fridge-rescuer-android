package com.fridgerescuer.domain.model.myingr

import android.graphics.Bitmap

data class MyIngrSample(
    val id: Int,
    val ingr_name: String,
    val due_date: String,
    val ingr_image: Bitmap,
)

