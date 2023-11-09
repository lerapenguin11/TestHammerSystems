package com.example.data.mappers

import com.example.data.api.CategoriesApiResponse
import com.example.data.api.ProductsApiResponse
import com.example.domain.entities.Categories
import com.example.domain.entities.Products

class FoodApiResponseMapper {

    fun toVolumeListCategories(response: CategoriesApiResponse): List<Categories> {
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

    fun toVolumeListProducts(response: ProductsApiResponse): List<Products> {
        var list = arrayListOf<Products>()
        for (i in response){
            val description = i.description
            val id = i.id
            val image = i.image
            val ingredients = i.ingredients
            val name = i.name
            val price = i.price
            val product_id = i.product_id

            val cat = Products(
                id = id,
                name = name,
                description = description,
                image = image,
                ingredients = ingredients,
                price = price,
                product_id = product_id)

            list.add(cat)
        }
        return list
    }
}