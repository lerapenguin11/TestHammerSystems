package com.example.testhammersystems.di

import com.example.domain.usecase.GetBannerListUseCase
import com.example.testhammersystems.viewmodel.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MenuViewModel> {
        MenuViewModel(
            getBannerListUseCase = GetBannerListUseCase(get())
        )
    }
}