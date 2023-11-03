package com.example.data.api

class CategoriesApiResponse(val items : List<CategoryItem>)

data class CategoryItem(
    val id: Int,
    val name: String
)