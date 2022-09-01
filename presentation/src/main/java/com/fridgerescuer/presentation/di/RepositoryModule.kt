package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.repository.ingr.IngrRepositoryImpl
import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSource
import com.fridgerescuer.data.repository.recipe.RecipeRepositoryImpl
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSource
import com.fridgerescuer.domain.repository.IngrRepository
import com.fridgerescuer.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideIngrRepository(
        ingrLocalDataSource: IngrLocalDataSource
    ): IngrRepository {
        return IngrRepositoryImpl(ingrLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeRemoteDataSource: RecipeRemoteDataSource
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeRemoteDataSource)
    }
}