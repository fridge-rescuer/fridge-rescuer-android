package com.fridgerescuer.data.repository.recipe

import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSource
import com.fridgerescuer.domain.model.recipe.Recipe
import com.fridgerescuer.domain.repository.RecipeRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImpl @Inject constructor(
    private val recipeRemoteDataSource: RecipeRemoteDataSource
): RecipeRepository {

    override fun getRecipe(): Flowable<List<Recipe>> {
        TODO("Not yet implemented")
    }
}