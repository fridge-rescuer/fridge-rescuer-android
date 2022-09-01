package com.fridgerescuer.domain.repository

import com.fridgerescuer.domain.model.recipe.Recipe
import io.reactivex.rxjava3.core.Flowable

interface RecipeRepository {
    fun getRecipe(): Flowable<List<Recipe>>
}