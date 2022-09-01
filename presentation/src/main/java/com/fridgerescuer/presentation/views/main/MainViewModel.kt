package com.fridgerescuer.presentation.views.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fridgerescuer.domain.model.ingr.IngrSample
import com.fridgerescuer.domain.model.recipe.Recipe
import com.fridgerescuer.domain.usecase.ingr.GetSomeIngrSampleUseCase
import com.fridgerescuer.domain.usecase.recipe.GetRecipeUseCase
import com.fridgerescuer.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSomeIngrSampleUseCase: GetSomeIngrSampleUseCase,
    private val getRecipeUseCase: GetRecipeUseCase
): BaseViewModel() {


    private val _ingrSampleList = MutableLiveData<MutableList<IngrSample>>()
    val ingrSampleList: LiveData<MutableList<IngrSample>> get() = _ingrSampleList

    private val _ingrSampleLoading = MutableLiveData<Boolean>(false)

    val ingrSampleLoading: LiveData<Boolean> get() = _ingrSampleLoading

    private val _recipeList = MutableLiveData<MutableList<Recipe>>()
    val recipeList: LiveData<MutableList<Recipe>> get() = _recipeList

    private val _recipeLoading = MutableLiveData<Boolean>(false)
    val recipeLoading: LiveData<Boolean> get() = _recipeLoading

    fun requestCloseIngrSample() {
        compositeDisposable.add(
            getSomeIngrSampleUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _ingrSampleLoading.value = true }
                .doAfterTerminate { _ingrSampleLoading.value = false }
                .subscribe { ingrSample ->
                    _ingrSampleList.value = ingrSample as ArrayList<IngrSample>
                }
        )
    }

    fun requestRecipe() {
        compositeDisposable.add(
            getRecipeUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _recipeLoading.value = true }
                .doAfterTerminate { _recipeLoading.value = false }
                .subscribe { recipes ->
                    _recipeList.value = recipes as ArrayList<Recipe>
                }
        )
    }

    fun requestIngr(id: Int) {

    }



}