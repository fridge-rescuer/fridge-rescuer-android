package com.fridgerescuer.presentation.views.myfridge.addingr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fridgerescuer.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddIngrViewModel @Inject constructor(

): BaseViewModel() {
    private val _expDate = MutableLiveData<String>("")
    val expDate: LiveData<String> get() = _expDate

    private val _useDate = MutableLiveData<String>("")
    val useDate: LiveData<String> get() = _useDate

    private val _buyDate = MutableLiveData<String>("")
    val buyDate: LiveData<String> get() = _buyDate

    private val _isAlert = MutableLiveData<Boolean>(false)
    val isAlert: LiveData<Boolean> get() = _isAlert

    private val _alertText = MutableLiveData<String>("")
    val alertText: LiveData<String> get() = _alertText

    fun addIngr(): Boolean {
        return true
    }
}