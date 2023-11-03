package com.example.testhammersystems.di

import com.example.domain.usecase.GetBannerListUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetBannerListUseCase> { GetBannerListUseCase(
        repository = get()
    ) }
}