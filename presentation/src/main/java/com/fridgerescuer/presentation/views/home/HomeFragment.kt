package com.fridgerescuer.presentation.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMainHomeBinding

//@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentMainHomeBinding>(
    R.layout.fragment_main_home
) {
    private val viewModel: HomeViewModel by viewModels()

    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    override fun initView() {
        binding.apply {

        }
    }


}

