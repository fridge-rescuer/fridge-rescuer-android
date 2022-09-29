package com.fridgerescuer.presentation.views.myfridge.addingr

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.viewModels
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentAddIngrBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class AddIngrFragment: BaseFragment<FragmentAddIngrBinding>(
    R.layout.fragment_add_ingr
) {
    private val viewModel: AddIngrViewModel by viewModels()

    @Override
    override fun initView() {
        // set databinding
        binding.vm = viewModel

        // set toolbar button
        initToolBar()

        // set storage spinner
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

        // adjust spinner list location
        spinner.dropDownVerticalOffset = 3

        // apply default adapter(spinner adapter) to spinner
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
        binding.addPhotoButton.setOnClickListener {
            viewModel
        }

        binding.expDateButton.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                viewModel.setExpDate("${year}-${month+1}-${dayOfMonth}")
            }
            DatePickerDialog(requireActivity(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.useDateButton.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                viewModel.setUseDate("${year}-${month+1}-${dayOfMonth}")
            }
            DatePickerDialog(requireActivity(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.buyDateButton.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                viewModel.setBuyDate("${year}-${month+1}-${dayOfMonth}")
            }
            DatePickerDialog(requireActivity(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.undoButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.saveButton.setOnClickListener {
            // apply selected item from spinner to view model
            viewModel.storage = binding.storageSpinner.selectedItem.toString()

            // call viewModel.addIngr - check the condition, if it's ok, go back, else display alert message
            when (viewModel.addIngr()){
                true -> requireActivity().onBackPressed()
                else -> null
            }
        }
    }
}