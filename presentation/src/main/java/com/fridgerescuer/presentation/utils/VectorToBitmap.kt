package com.fridgerescuer.presentation.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat.getDrawable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class VectorToBitmap @Inject constructor(@ApplicationContext private val context: Context) {

    fun getBitmapFromVector(drawableId: Int): Bitmap {
        val drawable: Drawable = getDrawable(context, drawableId)!!

        val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap;
    }
}