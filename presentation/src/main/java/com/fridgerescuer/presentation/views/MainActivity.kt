package com.fridgerescuer.presentation.views

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityMainBinding
import com.fridgerescuer.presentation.views.main.fragment.HomeFragment
import com.fridgerescuer.presentation.views.main.fragment.MyFridgeFragment
import com.fridgerescuer.presentation.views.main.fragment.RecipeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        selectNavItem()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

    private fun selectDrawerMypage() {
        if (!binding.parentLayout.isDrawerOpen(Gravity.RIGHT))
            binding.parentLayout.openDrawer(Gravity.RIGHT)
    }

    private fun selectNavItem() {
        binding.bottomNav.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> replaceFragment(HomeFragment())
                    R.id.navigation_myfridge -> replaceFragment(MyFridgeFragment())
                    R.id.navigation_recipe -> replaceFragment(RecipeFragment())
                    R.id.navigation_mypage -> selectDrawerMypage()
                }
                true
            }
            selectedItemId = R.id.navigation_home
        }
    }
}