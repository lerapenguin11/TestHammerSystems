package com.example.domain.usecase

import com.example.domain.entities.Banner
import com.example.domain.repository.MenuRepository

class GetBannerListUseCase(private val repository: MenuRepository) {

    operator fun invoke(list: MutableList<Banner>) = repository.getBannerList(list = list)
}