package com.example.testhammersystems.di

import android.content.Context
import com.example.data.api.NetworkModule
import com.example.data.repository.MenuDataSourceImpl
import com.example.data.repository.MenuRepositoryImpl

/*
object ServiceLocator {
    private val networkModule by lazy {
        NetworkModule()
    }

    @Volatile
    var booksRepository: MenuRepositoryImpl? = null

    fun provideBooksRepository(context: Context): MenuRepositoryImpl {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return booksRepository ?: createBooksRepository(context)
        }
    }

    private fun createBooksRepository(context: Context): MenuRepositoryImpl {
        val newRepo =
            MenuRepositoryImpl(
                createBooksLocalDataSource(context),
                MenuDataSourceImpl(
                    networkModule.createBooksApi(BuildConfig.GOOGLE_APIS_ENDPOINT),
                    BookApiResponseMapper()
                )
            )
        booksRepository = newRepo
        return newRepo
    }

    private fun createBooksLocalDataSource(context: Context): BooksLocalDataSource {
        val database = database ?: createDataBase(context)
        return BooksLocalDataSourceImpl(
            database.bookDao(),
            Dispatchers.IO,
            bookEntityMapper
        )
    }

    private fun createDataBase(context: Context): BooksDatabase {
        val result = BooksDatabase.getDatabase(context)
        database = result
        return result
    }
}*/
