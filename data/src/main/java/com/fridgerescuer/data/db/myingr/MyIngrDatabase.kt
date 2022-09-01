package com.fridgerescuer.data.db.myingr

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fridgerescuer.data.model.ingr.IngrEntity

@Database(entities = [IngrEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MyIngrDatabase:RoomDatabase() {
    abstract fun myIngrDao(): MyIngrDao
}