package com.fridgerescuer.presentation.views.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fridgerescuer.presentation.R

class MainIngrFragment : Fragment() {

    companion object {
        fun newInstance() = MainIngrFragment()
    }

    private lateinit var viewModel: MainIngrViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_ingr, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainIngrViewModel::class.java)
        // TODO: Use the ViewModel
    }

}