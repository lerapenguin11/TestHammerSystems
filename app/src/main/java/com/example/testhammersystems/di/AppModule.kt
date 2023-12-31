package com.example.testhammersystems.di

import com.example.domain.usecase.GetBannerListUseCase
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.domain.usecase.GetProductsUseCase
import com.example.testhammersystems.viewmodel.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MenuViewModel> {
        MenuViewModel(
            getBannerListUseCase = GetBannerListUseCase(get()),
            getCategoriesUseCase = GetCategoriesUseCase(get()),
            getProductsUseCase = GetProductsUseCase(get())
        )
    }
}