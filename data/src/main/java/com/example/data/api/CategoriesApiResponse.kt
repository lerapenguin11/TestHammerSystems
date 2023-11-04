package com.example.data.api

import com.google.gson.annotations.SerializedName

class CategoriesApiResponse: ArrayList<CategoryItem>()

data class CategoryItem(
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "name")
    val name: String
)