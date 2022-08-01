package com.fridgerescuer.presentation.views.recipe

import android.os.Bundle
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityRecipeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity: BaseActivity<ActivityRecipeBinding>(
    R.layout.activity_recipe
) {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}