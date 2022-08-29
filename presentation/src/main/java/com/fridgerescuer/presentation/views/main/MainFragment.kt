package com.fridgerescuer.presentation.views.main

import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.INVISIBLE
import android.widget.ScrollView
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
    private lateinit var ingrSampleAdapter: IngrSampleAdapter
    private lateinit var recipeAdapter: RecipeAdapter


    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    @Override
    override fun initView() {
        initToolBar()
        initButton()
        initMyIngr()
        initDietInfo()
        initStickyScroll()
    }

    private fun initToolBar() {
        binding.toolbar.inflateMenu(R.menu.toolbar_main)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.toolbar_mypage -> {
                    requireView().findNavController().navigate(R.id.action_mainFragment_to_mypageFragment)
                    true
                }
                R.id.toolbar_location -> {
                    // click action
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
        binding.dietButton.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_mainFragment_to_recipeFragment)
        }
    }

    private fun initMyIngr() {

    }

    private fun initDietInfo() {

    }

    private fun initStickyScroll() {
        binding.mainScrollView.run {
            header = binding.scrollTabLayout
            stickListener = { _ ->
                binding.toolbar.menu.clear()
                binding.toolbar.inflateMenu(R.menu.toolbar_scroll)
                binding.toolbar.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.toolbar_top -> {
                            this.fullScroll(ScrollView.FOCUS_UP)
                            true
                        }
                        R.id.toolbar_setting -> {
                            // tab set dialog
                            true
                        }
                        else -> false
                    }
                }
            }
            freeListener = { _ ->
                binding.toolbar.menu.clear()
                initToolBar()
            }
        }
        initTab()
    }
    private fun initTab() {

    }
    private fun initRecipeList() {

    }



    /*
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