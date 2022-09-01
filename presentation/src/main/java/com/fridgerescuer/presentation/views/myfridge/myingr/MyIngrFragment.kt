package com.fridgerescuer.presentation.views.myfridge.myingr

import androidx.fragment.app.viewModels
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMyIngrBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyIngrFragment : BaseFragment<FragmentMyIngrBinding>(
    R.layout.fragment_my_ingr
) {
    private val viewModel: MyIngrViewModel by viewModels()

    @Override
    override fun initView() {

    }

}