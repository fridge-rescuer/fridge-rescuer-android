package com.fridgerescuer.presentation.views.location

import android.os.Bundle
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationActivity: BaseActivity<ActivityLocationBinding>(
    R.layout.activity_location
) {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}