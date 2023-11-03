package com.example.data.repository

import com.example.domain.common.ResultFood
import com.example.domain.entities.Banner
import com.example.domain.entities.Categories
import com.example.domain.repository.MenuRepository

class MenuRepositoryImpl(
    private val dataSource: MenuDataSource
) : MenuRepository{

    override fun getBannerList(list: MutableList<Banner>): MutableList<Banner> {
        return dataSource.getBannerList(list = list)
    }

    override suspend fun getCategories(): ResultFood<List<Categories>> {
        return dataSource.getCategories()
    }
}