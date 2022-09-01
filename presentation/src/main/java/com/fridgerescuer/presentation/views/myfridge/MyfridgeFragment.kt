package com.fridgerescuer.presentation.views.myfridge

import androidx.fragment.app.viewModels
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyfridgeFragment : BaseFragment<FragmentMainBinding>(
    R.layout.fragment_myfridge
) {
    private val viewModel: MyfridgeViewModel by viewModels()


    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    @Override
    override fun initView() {

    }
}