package com.fridgerescuer.data.db.ingr

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fridgerescuer.data.model.myfridge.IngrEntity

@Dao
interface IngrDao {
    // 삽입 - 여러개
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngrs(vararg fridge:IngrEntity)
    // 한줄
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngr(fridge:IngrEntity)

    // 삭제 - 전체
    @Query("DELETE FROM ingrs")
    fun deleteAll()
    // 한줄
    @Query("DELETE FROM ingrs where id = :id")
    fun deleteIngr(id: Short)

    // 탐색 - 전체
    @Query("SELECT * FROM ingrs")
    fun getAll():List<IngrEntity>
    // 한줄
    @Query("SELECT * FROM ingrs where id = :id")
    fun getIngr(id:Short):IngrEntity

}