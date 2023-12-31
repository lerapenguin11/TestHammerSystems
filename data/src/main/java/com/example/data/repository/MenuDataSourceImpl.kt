package com.example.data.repository

import com.example.data.api.FoodApi
import com.example.data.mappers.FoodApiResponseMapper
import com.example.domain.common.ResultFood
import com.example.domain.entities.Banner
import com.example.domain.entities.Categories
import com.example.domain.entities.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MenuDataSourceImpl(
    private val service: FoodApi,
    private val mapper: FoodApiResponseMapper
) : MenuDataSource {

    override fun getBannerList(list: MutableList<Banner>): MutableList<Banner> {
        val bannerList = mutableListOf<Banner>()

        for (i in list){
            val icon = i.icon
            val id = i.id

            val listLetterModel = Banner(icon = icon, id = id)

            bannerList.add(listLetterModel)
        }

        return bannerList
    }

    override suspend fun getCategories(): ResultFood<List<Categories>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCategories()

                if (response.raw().cacheResponse != null){
                    return@withContext ResultFood.Success(mapper.toVolumeListCategories(response.body()!!))
                }
                else if (response.isSuccessful()) {
                    return@withContext ResultFood.Success(mapper.toVolumeListCategories(response.body()!!))
                } else {
                    return@withContext ResultFood.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext ResultFood.Error(e)
            }
        }

    override suspend fun getProducts(categoryId: String): ResultFood<List<Products>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getProduct(id = categoryId)

                if (response.raw().cacheResponse != null){
                    return@withContext ResultFood.Success(mapper.toVolumeListProducts(response.body()!!))
                }
                else if (response.isSuccessful()) {
                    return@withContext ResultFood.Success(mapper.toVolumeListProducts(response.body()!!))
                } else {
                    return@withContext ResultFood.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext ResultFood.Error(e)
            }
        }
}