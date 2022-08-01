package com.fridgerescuer.presentation.views.myfridge

import android.os.Bundle
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityMyfridgeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyfridgeActivity: BaseActivity<ActivityMyfridgeBinding>(
    R.layout.activity_myfridge
) {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}