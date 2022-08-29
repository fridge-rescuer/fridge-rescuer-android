package com.fridgerescuer.presentation.utils

import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fridgerescuer.domain.model.ingr.IngrSample
import com.fridgerescuer.presentation.views.main.IngrSampleAdapter

@BindingAdapter("setItems")
fun RecyclerView.setAdapterItems(items: MutableList<IngrSample>?) {
    items?.let {
        (adapter as IngrSampleAdapter).submitList(it.toMutableList())
    }
}

@BindingAdapter("setBitmapImage")
fun ImageView.setBitmapImage(bitmap: Bitmap) {
    setImageBitmap(bitmap)
}

@BindingAdapter("setText")
fun TextView.setText(string: String) {
    text = string
}