package com.fridgerescuer.presentation.utils

import android.app.Activity
import android.widget.Toast
import com.fridgerescuer.presentation.R

class BackPressUtil(private val activity: Activity) {
    private var backKeyPressedTime = 0L
    private var toast: Toast? = null

    fun onBackPressed() {
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            toast!!.cancel()
            activity.finish()
        } else {
            backKeyPressedTime = System.currentTimeMillis()
            showToast()
        }
    }

    private fun showToast() {
        toast =
            Toast.makeText(activity, activity.getString(R.string.finish_app), Toast.LENGTH_SHORT)
        toast!!.show()
    }
}