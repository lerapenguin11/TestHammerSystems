package com.example.data.repository

import com.example.domain.common.ResultFood
import com.example.domain.entities.Banner
import com.example.domain.entities.Categories
import com.example.domain.entities.Products

interface MenuDataSource {

    fun getBannerList(list : MutableList<Banner>) : MutableList<Banner>

    suspend fun getCategories(): ResultFood<List<Categories>>

    suspend fun getProducts(categoryId : String): ResultFood<List<Products>>
}