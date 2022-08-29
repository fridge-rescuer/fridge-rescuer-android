package com.fridgerescuer.domain.model.ingr

import android.graphics.Bitmap

data class IngrSample(
    val id: Int,
    val ingr_name: String,
    val due_date: String,
    val ingr_image: Bitmap,
)

