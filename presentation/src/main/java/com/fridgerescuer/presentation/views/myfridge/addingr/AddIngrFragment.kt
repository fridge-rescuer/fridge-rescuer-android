package com.fridgerescuer.presentation.views.myfridge.addingr

import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
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
        initSpinner()
        initButton()
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

    private fun initSpinner() {
        val spinner: Spinner = binding.storageSpinner

        spinner.layoutParams.height = binding.expDateButton.height
        spinner.dropDownVerticalOffset = 3

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.storage,
            android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun initButton() {
        binding.undoButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.saveButton.setOnClickListener {
            when (viewModel.addIngr()){
                true -> requireActivity().onBackPressed()
                else -> null
            }
        }
    }
}