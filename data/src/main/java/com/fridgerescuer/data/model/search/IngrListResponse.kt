package com.fridgerescuer.data.model.search

import com.google.gson.annotations.SerializedName

data class IngrListResponse (
    @SerializedName("query")
    val query: String,

    @SerializedName("display")
    val display: Int,

    @SerializedName("ingrList")
    val ingrList: List<String>,

    @SerializedName("total")
    val total: Int,

    @SerializedName("lastBuildDate")
    val lastBuildDate: String
)