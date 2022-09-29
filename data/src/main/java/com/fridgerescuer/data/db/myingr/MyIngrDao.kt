package com.fridgerescuer.data.db.myingr

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fridgerescuer.data.model.myingr.MyIngrEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface MyIngrDao {
    // 삽입 - 여러개
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngrs(vararg myIngr: MyIngrEntity)
    // 한줄
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngr(myIngr: MyIngrEntity): Completable

    // 삭제 - 전체
    @Query("DELETE FROM myIngrs")
    fun deleteAll()
    // 한줄
    @Query("DELETE FROM myIngrs where id = :id")
    fun deleteIngr(id: Int)

    // 탐색 - 전체
    @Query("SELECT * FROM myIngrs")
    fun getAll(): Single<List<MyIngrEntity>>
    // 한줄
    @Query("SELECT * FROM myIngrs where id = :id")
    fun getIngr(id:Int): MyIngrEntity

}