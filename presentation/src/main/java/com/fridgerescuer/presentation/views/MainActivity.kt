package com.fridgerescuer.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseActivity
import com.fridgerescuer.presentation.databinding.ActivityMainBinding
import com.fridgerescuer.presentation.utils.BackPressUtil
import com.fridgerescuer.presentation.views.home.HomeFragment
import com.fridgerescuer.presentation.views.myfridge.MyFridgeFragment
import com.fridgerescuer.presentation.views.recipe.RecipeFragment

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

    private fun selectNavItem() {
        binding.navView.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> replaceFragment(HomeFragment())
                    R.id.navigation_myfridge -> replaceFragment(MyFridgeFragment())
                    R.id.navigation_recipe -> replaceFragment(RecipeFragment())
                }
                true
            }
            selectedItemId = R.id.navigation_home
        }
    }
}