package com.fridgerescuer.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.fridgerescuer.presentation.R
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<B: ViewDataBinding>(
    @LayoutRes val layoutId: Int
): AppCompatActivity() {

    lateinit var binding: B
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@BaseActivity, layoutId)
        binding.lifecycleOwner = this@BaseActivity
    }

    @Override
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
