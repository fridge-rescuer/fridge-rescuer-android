package com.fridgerescuer.presentation.views.main

import android.widget.ScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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
        initButtons()
        initMyIngrs()
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
                else -> false
            }
        }
    }

    private fun initButtons() {
        binding.searchButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }
        binding.myfridgeButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_myfridgeFragment)
        }
        binding.recipeButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_recipeFragment)
        }
        binding.dietButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_recipeFragment)
        }
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addIngrFragment)
        }
    }

    private fun initMyIngrs() {
        viewModel.requestCloseIngrSample()

        ingrSampleAdapter = IngrSampleAdapter { ingrSample ->
            if (ingrSample.id != null)
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToMyIngrFragment(ingrSample.id))
        }
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