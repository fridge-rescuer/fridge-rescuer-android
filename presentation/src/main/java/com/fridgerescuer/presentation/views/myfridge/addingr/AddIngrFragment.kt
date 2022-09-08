package com.fridgerescuer.presentation.views.myfridge.addingr

import androidx.fragment.app.viewModels
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentAddIngrBinding

class AddIngrFragment: BaseFragment<FragmentAddIngrBinding>(
    R.layout.fragment_add_ingr
) {
    private val viewModel: AddIngrViewModel by viewModels()

    @Override
    override fun initView() {
        initToolBar()
    }

    private fun initToolBar() {
        binding.toolbar.inflateMenu(R.menu.toolbar_default)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.toolbar_back -> {
                    requireActivity().onBackPressed()
                    true
                }
                else -> false
            }
        }
    }
}