package com.example.data.api

class ProductsApiResponse : ArrayList<ProductItem>()

data class ProductItem(
    val description: String,
    val id: Int,
    val image: String,
    val ingredients: String,
    val name: String,
    val price: Int,
    val product_id: Int
)