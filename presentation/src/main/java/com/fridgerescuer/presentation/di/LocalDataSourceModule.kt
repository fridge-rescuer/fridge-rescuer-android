package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSource
import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSourcelmpl
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSource
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindIngrLocalDataSourcelmpl(impl: IngrLocalDataSourcelmpl): IngrLocalDataSource

    @Binds
    @Singleton
    abstract fun bindRecipeRemoteDataSourceImpl(impl: RecipeRemoteDataSourceImpl): RecipeRemoteDataSource
}