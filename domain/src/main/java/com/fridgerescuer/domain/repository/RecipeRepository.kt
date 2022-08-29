package com.fridgerescuer.domain.repository

import com.fridgerescuer.domain.model.recipe.Recipe
import io.reactivex.Flowable

interface RecipeRepository {
    fun getRecipe(): Flowable<List<Recipe>>
}