package com.fridgerescuer.presentation.views.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMainRecipeBinding
import com.fridgerescuer.presentation.views.home.HomeViewModel

@AndroidEntryPoint
class RecipeFragment: BaseFragment<FragmentMainRecipeBinding>(
    R.layout.fragment_main_recipe
) {
    private val viewModel: HomeViewModel by viewModels()

    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    override fun initView() {
        binding.apply {

        }
    }
}