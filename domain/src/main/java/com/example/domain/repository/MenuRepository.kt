package com.example.domain.repository

import com.example.domain.entities.Banner
import com.example.domain.entities.Categories

interface MenuRepository {

    fun getBannerList(list : MutableList<Banner>) : MutableList<Banner>

    suspend fun getCategories(): Result<List<Categories>>
}