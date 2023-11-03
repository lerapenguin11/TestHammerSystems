package com.example.data.repository

import com.example.domain.common.ResultFood
import com.example.domain.entities.Banner
import com.example.domain.entities.Categories

interface MenuDataSource {

    fun getBannerList(list : MutableList<Banner>) : MutableList<Banner>

    suspend fun getCategories(): ResultFood<List<Categories>>
}