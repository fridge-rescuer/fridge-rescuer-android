package com.fridgerescuer.presentation.views.mypage

import android.os.Bundle
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityMypageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MypageActivity: BaseActivity<ActivityMypageBinding>(
    R.layout.activity_mypage
) {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}