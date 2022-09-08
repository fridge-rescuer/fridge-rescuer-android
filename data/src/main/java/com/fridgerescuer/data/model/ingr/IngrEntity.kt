package com.fridgerescuer.data.model.ingr

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingrs")
data class IngrEntity(
    @PrimaryKey val id:Int,
    // required - 식재료 id, 이름, 유통 기한, 보관 장소
    val ingr_id: Short,
    val ingr_name: String,
    val exp_date: String,
    val storage: Int,

    // optional - 식재료 사진, 이용 기한, 구매일, 칼로리, 선호
    val ingr_image: Bitmap,
    val buy_date: String? = null,
    val use_date: String? = null,
    val kcal: Int? = null,
    val ingr_like: Boolean = false,

    // storage - 보관 사진, 보관 방법
    val store_image: Bitmap? = null,
    val store_str: String? = null

){
    override fun toString(): String {
        return "id = $id, " +
                "ingr_id = $ingr_id, " +
                "ingr_name = $ingr_name, " +
                "buy_date = $buy_date, " +
                "exp_date = $exp_date, " +
                "storage = $storage, " +
                "ingr_image = $ingr_image, " +
                "use_date = $use_date, " +
                "kcal = $kcal, " +
                "ingr_like = $ingr_like, " +
                "store_image = $store_image, " +
                "store_str = $store_str"
    }
}
