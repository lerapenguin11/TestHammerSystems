package com.example.testhammersystems.di

import com.example.domain.usecase.GetBannerListUseCase
import com.example.domain.usecase.GetCategoriesUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetBannerListUseCase> { GetBannerListUseCase(
        repository = get()
    ) }

    factory<GetCategoriesUseCase> { GetCategoriesUseCase(
        repository = get()
    ) }
}