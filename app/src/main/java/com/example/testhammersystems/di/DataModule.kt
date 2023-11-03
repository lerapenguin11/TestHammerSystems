package com.example.testhammersystems.di

import com.example.data.repository.MenuDataSource
import com.example.data.repository.MenuDataSourceImpl
import com.example.data.repository.MenuRepositoryImpl
import com.example.domain.repository.MenuRepository
import org.koin.dsl.module

val dataModule = module {
    single<MenuDataSource> { MenuDataSourceImpl() }
    single<MenuRepository> { MenuRepositoryImpl(get()) }
}