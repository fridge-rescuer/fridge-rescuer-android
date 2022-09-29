package com.fridgerescuer.presentation.views.myfridge.addingr

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fridgerescuer.domain.model.myingr.MyIngr
import com.fridgerescuer.domain.usecase.ingr.InsertMyIngrUseCase
import com.fridgerescuer.presentation.R
import com.fridgerescuer.presentation.base.BaseViewModel
import com.fridgerescuer.presentation.utils.VectorToBitmap
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AddIngrViewModel @Inject constructor(
    private val insertMyIngrUseCase: InsertMyIngrUseCase,
    @ApplicationContext private val contextApp: Context
): BaseViewModel() {

    private var currentName: String = ""
    val name = MutableLiveData<String>("")

    private val _expDate = MutableLiveData<String>("")
    val expDate: LiveData<String> get() = _expDate
    fun setExpDate(string: String) {
        _expDate.value = string
    }

    var storage: String = ""

    private val _useDate = MutableLiveData<String>("")
    val useDate: LiveData<String> get() = _useDate
    fun setUseDate(string: String) {
        _useDate.value = string
    }

    private val _buyDate = MutableLiveData<String>("")
    val buyDate: LiveData<String> get() = _buyDate
    fun setBuyDate(string: String) {
        _buyDate.value = string
    }

    private val _image = MutableLiveData<Bitmap?>(null)
    val image: LiveData<Bitmap> get() = bitmapMapper(_image)
    // function to solve MutableLiveData value is nullable, and to apply the default value when null
    private fun bitmapMapper(mutableLiveData: MutableLiveData<Bitmap?>): MutableLiveData<Bitmap> {
        return if (mutableLiveData.value == null)
            MutableLiveData<Bitmap>(VectorToBitmap(contextApp).getBitmapFromVector(R.drawable.ic_temp_image_600dp))
        else
            MutableLiveData<Bitmap>(mutableLiveData.value)
    }

    private val _isAlert = MutableLiveData<Boolean>(false)
    val isAlert: LiveData<Boolean> get() = _isAlert

    private val _alertText = MutableLiveData<String>("")
    val alertText: LiveData<String> get() = _alertText

    fun addIngr(): Boolean {
        val ingr = makeIngr() ?: return false

        compositeDisposable.add(
            insertMyIngrUseCase(ingr)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
        return true
    }

    private fun makeIngr(): MyIngr? {
        currentName = name.value.toString()
        if (currentName == "") return null
        if (_expDate.value == "") return null
        if (storage == "") return null

        return MyIngr(
            0,
            0,
            currentName,
            _expDate.value!!,
            storage,
            _image.value,
            _buyDate.value,
            _useDate.value
        )
    }
}