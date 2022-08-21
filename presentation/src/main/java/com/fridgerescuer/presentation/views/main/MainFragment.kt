package com.fridgerescuer.presentation.views.main

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(
    R.layout.fragment_main
) {
    private val viewModel: MainViewModel by viewModels()


    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    @Override
    override fun initView() {
        initToolBar()
        initButton()

        //initMyIngr()
    }

    private fun initToolBar() {
        binding.toolbar.inflateMenu(R.menu.toolbar_main)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_mypage -> {
                    requireView().findNavController().navigate(R.id.action_mainFragment_to_mypageFragment)
                    true
                }
                R.id.action_location -> {
                    // Save profile changes
                    true
                }
                else -> false
            }
        }
    }

    private fun initButton() {
        binding.searchButton.setOnClickListener {
            view: View -> view.findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }
        binding.myfridgeButton.setOnClickListener {
            view: View -> view.findNavController().navigate(R.id.action_mainFragment_to_myfridgeFragment)
        }
        binding.recipeButton.setOnClickListener {
            view: View -> view.findNavController().navigate(R.id.action_mainFragment_to_recipeFragment)
        }
    }





    /*
    private fun initButton() {
        // search bar
        binding.searchButton.setOnClickListener {
            startActivity(Intent(this@MainFragment, SearchActivity::class.java))
            overridePendingTransition(R.anim.anim_rightin, 0)
        }

        // myfridge, recipe button
        binding.myfridgeButton.setOnClickListener {
            startActivity(Intent(this@MainFragment, MyfridgeActivity::class.java))
            overridePendingTransition(R.anim.anim_rightin, 0)
        }
        binding.mainRecipeButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecipeActivity::class.java))
            overridePendingTransition(R.anim.anim_rightin, 0)
        }
    }

    private fun initMyIngr(){
        val ingrView0 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.ingrContainer, true)
        val ingrView1 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.ingrContainer, true)
        val ingrView2 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.ingrContainer, true)
        val ingrView3 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.ingrContainer, true)
        val ingrView4 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.ingrContainer, true)
        val ingrView5 = LayoutInflater.from(this).inflate(R.layout.view_ingr, binding.ingrContainer, true)


    }
    */
}