package com.fridgerescuer.domain.usecase.recipe

import com.fridgerescuer.domain.model.recipe.Recipe
import com.fridgerescuer.domain.repository.RecipeRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(private val repository: RecipeRepository) {

    operator fun invoke(): Flowable<List<Recipe>> = repository.getRecipe()
}