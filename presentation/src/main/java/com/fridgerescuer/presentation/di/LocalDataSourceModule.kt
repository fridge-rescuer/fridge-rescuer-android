package com.fridgerescuer.presentation.di

import com.fridgerescuer.data.db.myingr.MyIngrDao
import com.fridgerescuer.data.repository.myingr.local.MyIngrLocalDataSource
import com.fridgerescuer.data.repository.myingr.local.MyIngrLocalDataSourceImpl
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
    fun provideMyIngrLocalDataSourceImpl(myIngrDao: MyIngrDao): MyIngrLocalDataSource {
        return MyIngrLocalDataSourceImpl(myIngrDao)
    }
}