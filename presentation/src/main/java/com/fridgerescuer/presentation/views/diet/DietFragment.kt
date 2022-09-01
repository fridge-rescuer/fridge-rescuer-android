package com.fridgerescuer.presentation.views.diet

import androidx.fragment.app.viewModels
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentDietBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DietFragment : BaseFragment<FragmentDietBinding>(
    R.layout.fragment_diet
) {
    private val viewModel: DietViewModel by viewModels()


    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    @Override
    override fun initView() {

    }
}