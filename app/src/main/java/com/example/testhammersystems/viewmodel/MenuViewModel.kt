package com.example.testhammersystems.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultFood
import com.example.domain.entities.Banner
import com.example.domain.entities.Categories
import com.example.domain.usecase.GetBannerListUseCase
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.testhammersystems.Constants
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getBannerListUseCase: GetBannerListUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel(){

    private val _dataLoading = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _remoteBooks = arrayListOf<Categories>()
    val remoteBooks = _remoteBooks

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getBanner(): MutableList<Banner> {
        var mutableData = mutableListOf<Banner>()
        viewModelScope.launch{
            mutableData = getBannerListUseCase.invoke(Constants.getBanner())
        }

        return mutableData
    }

    fun getCategories() {
        viewModelScope.launch {
            _dataLoading.postValue(true)
            when (val booksResult = getCategoriesUseCase.invoke()) {
                is ResultFood.Success -> {
                    _remoteBooks.clear()
                    _remoteBooks.addAll(booksResult.data)
                }

                is ResultFood.Error -> {
                    _dataLoading.postValue(false)
                    _error.postValue(booksResult.exception.message)
                }
            }
        }
    }
}