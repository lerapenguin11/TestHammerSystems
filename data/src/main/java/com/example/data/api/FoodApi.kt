package com.example.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {
    @Headers("Cache-Control: max-age=3600")
    @GET("products")
    suspend fun getCategories(): Response<CategoriesApiResponse>

    @Headers("Cache-Control: max-age=3600")
    @GET("products/{id}/types")
    suspend fun getProduct(@Path("id") id: String): Response<ProductsApiResponse>
}