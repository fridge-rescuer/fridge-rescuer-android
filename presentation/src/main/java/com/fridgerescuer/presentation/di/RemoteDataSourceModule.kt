package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSource
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideRecipeRemoteDataSourceImpl(): RecipeRemoteDataSource {
        return RecipeRemoteDataSourceImpl()
    }
}