package com.fridgerescuer.presentation.views.main.fragment

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMainHomeBinding
import com.fridgerescuer.presentation.views.main.home.HomeViewModel

@AndroidEntryPoint
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

