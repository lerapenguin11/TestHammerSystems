package com.example.testhammersystems.di

import com.example.data.api.NetworkModule
import com.example.data.mappers.FoodApiResponseMapper
import com.example.data.repository.MenuDataSource
import com.example.data.repository.MenuDataSourceImpl
import com.example.data.repository.MenuRepositoryImpl
import com.example.domain.repository.MenuRepository
import com.example.testhammersystems.utilits.URL
import org.koin.dsl.module

val dataModule = module {
    val networkModule by lazy {
        NetworkModule()
    }
    single<MenuDataSource> { MenuDataSourceImpl(get(), get()) }
    single<MenuRepository> { MenuRepositoryImpl(get()) }
    single { FoodApiResponseMapper() }
    single { networkModule.createBooksApi(URL) }
}