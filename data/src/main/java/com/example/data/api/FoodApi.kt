package com.example.data.api

import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {
    @GET("/products")
    suspend fun getCategories(): Response<CategoriesApiResponse>
}