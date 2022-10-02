package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.repository.myingr.MyMyIngrRepositoryImpl
import com.fridgerescuer.data.repository.myingr.local.MyIngrLocalDataSource
import com.fridgerescuer.data.repository.recipe.RecipeRepositoryImpl
import com.fridgerescuer.data.repository.recipe.remote.RecipeRemoteDataSource
import com.fridgerescuer.data.repository.search.SearchRepositoryImpl
import com.fridgerescuer.data.repository.search.remote.SearchRemoteDataSource
import com.fridgerescuer.domain.repository.MyIngrRepository
import com.fridgerescuer.domain.repository.RecipeRepository
import com.fridgerescuer.domain.repository.SearchRepository
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
    fun provideMyIngrRepository(
        myIngrLocalDataSource: MyIngrLocalDataSource
    ): MyIngrRepository {
        return MyMyIngrRepositoryImpl(myIngrLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeRemoteDataSource: RecipeRemoteDataSource
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideSearchRepository(
        searchRemoteDataSource: SearchRemoteDataSource
    ): SearchRepository {
        return SearchRepositoryImpl(searchRemoteDataSource)
    }
}