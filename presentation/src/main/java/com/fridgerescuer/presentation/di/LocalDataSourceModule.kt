package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.db.myingr.MyIngrDao
import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSource
import com.fridgerescuer.data.repository.ingr.local.IngrLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideIngrLocalDataSourceImpl(myIngrDao: MyIngrDao): IngrLocalDataSource {
        return IngrLocalDataSourceImpl(myIngrDao)
    }
}