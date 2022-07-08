package com.fridgerescuer.data.db.ingr

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fridgerescuer.data.model.myfridge.IngrEntity

@Database(entities = [IngrEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class IngrDatabase:RoomDatabase() {

    companion object {
        // singleton pattern
        private var Instance:IngrDatabase? = null

        fun getInstance(context:Context):IngrDatabase? {
            if(Instance == null) {
                synchronized(IngrDatabase::class){
                    Instance = Room.databaseBuilder(
                        context,
                        IngrDatabase::class.java,
                        "ingredients"
                    ).build()

                }
            }
            return Instance
        }
        fun deleteInstance() {
            Instance = null
        }
    }

    abstract fun IngrDao(): IngrDao
}