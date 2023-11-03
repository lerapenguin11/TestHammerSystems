package com.example.domain.usecase

import com.example.domain.repository.MenuRepository

class GetCategoriesUseCase(private val repository: MenuRepository) {

    suspend operator fun invoke() = repository.getCategories()
}