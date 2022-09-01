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
    fun provideIngrDao(myIngrDatabase: MyIngrDatabase): MyIngrDao {
        return myIngrDatabase.myIngrDao()
    }

    @Singleton
    @Provides
    fun provideIngrRoom(@ApplicationContext context: Context): MyIngrDatabase {
        return Room.databaseBuilder(
            context,
            MyIngrDatabase::class.java,
            "Ingr.db"
        ).build()
    }
}