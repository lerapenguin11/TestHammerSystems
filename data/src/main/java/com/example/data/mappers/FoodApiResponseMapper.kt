package com.example.data.mappers

import com.example.data.api.CategoriesApiResponse
import com.example.domain.entities.Categories

class FoodApiResponseMapper {
    fun toVolumeList(response: CategoriesApiResponse): List<Categories> {
        var list = arrayListOf<Categories>()
        for (i in response){
            val id = i.id
            val name = i.name

            val cat = Categories(
                id = id, name = name)
            list.add(cat)
        }
        return list
    }
}