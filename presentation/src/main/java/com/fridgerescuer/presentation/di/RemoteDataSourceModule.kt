package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.api.ApiInterface
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSource
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSourceImpl
import com.fridgerescuer.data.repository.search.remote.SearchRemoteDataSource
import com.fridgerescuer.data.repository.search.remote.SearchRemoteDataSourceImpl
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

    @Singleton
    @Provides
    fun provideSearchRemoteDataSourceImpl(apiInterface: ApiInterface): SearchRemoteDataSource {
        return SearchRemoteDataSourceImpl(apiInterface)
    }
}