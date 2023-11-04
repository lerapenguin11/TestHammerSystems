package com.example.domain.usecase

import com.example.domain.repository.MenuRepository

class GetProductsUseCase(private val repository: MenuRepository) {

    suspend operator fun invoke(id : String) = repository.getProducts(categoryId = id)
}