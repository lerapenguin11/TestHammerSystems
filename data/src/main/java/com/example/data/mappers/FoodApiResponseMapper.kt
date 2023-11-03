package com.example.data.mappers

import com.example.data.api.CategoriesApiResponse
import com.example.domain.entities.Categories

class FoodApiResponseMapper {
    fun toVolumeList(response: CategoriesApiResponse): List<Categories> {
        return response.items.map {
            Categories(
                it.id, it.name)
        }
    }
}