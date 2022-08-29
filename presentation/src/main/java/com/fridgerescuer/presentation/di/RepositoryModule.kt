package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.repository.ingr.IngrRepositorylmpl
import com.fridgerescuer.data.repository.recipe.RecipeRepositoryImpl
import com.fridgerescuer.domain.repository.IngrRepository
import com.fridgerescuer.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIngrRepositoryImpl(impl: IngrRepositorylmpl): IngrRepository

    @Binds
    @Singleton
    abstract fun bindRecipeRepositoryImpl(impl: RecipeRepositoryImpl): RecipeRepository
}