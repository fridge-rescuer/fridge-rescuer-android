package com.fridgerescuer.presentation.views.mypage

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseFragment
import com.fridgerescuer.presentation.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MypageFragment : BaseFragment<FragmentMainBinding>(
    R.layout.fragment_mypage
) {
    private val viewModel: MypageViewModel by viewModels()


    //onViewCreated() override 에서 livedata observing, view 초기값, adapter(recyclerview, viewpager2) 설정

    @Override
    override fun initView() {

    }
}