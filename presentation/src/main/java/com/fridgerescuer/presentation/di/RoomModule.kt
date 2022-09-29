package com.fridgerescuer.presentation.di

import android.content.Context
import androidx.room.Room
import com.fridgerescuer.data.db.myingr.MyIngrDao
import com.fridgerescuer.data.db.myingr.MyIngrDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideMyIngrRoom(@ApplicationContext context: Context): MyIngrDatabase {
        return Room.databaseBuilder(
            context,
            MyIngrDatabase::class.java,
            "myIngr.db"
        ).build()
    }
    @Singleton
    @Provides
    fun provideMyIngrDao(myIngrDatabase: MyIngrDatabase): MyIngrDao {
        return myIngrDatabase.myIngrDao()
    }
}