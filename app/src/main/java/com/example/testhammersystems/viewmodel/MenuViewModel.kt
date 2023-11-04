package com.example.testhammersystems.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultFood
import com.example.domain.entities.Banner
import com.example.domain.entities.Categories
import com.example.domain.entities.Products
import com.example.domain.usecase.GetBannerListUseCase
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.domain.usecase.GetProductsUseCase
import com.example.testhammersystems.Constants
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getBannerListUseCase: GetBannerListUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel(){

    private val _dataLoadingCategory = MutableLiveData(true)
    val dataLoadingCategory: LiveData<Boolean> = _dataLoadingCategory

    private val _remoteCategory = arrayListOf<Categories>()
    val remoteCategory = _remoteCategory

    private val _errorCategory = MutableLiveData<String>()
    val errorCategory: LiveData<String> = _errorCategory

    private val _categoryList = MutableLiveData<List<Categories>>()
    val categoryListLiveData : LiveData<List<Categories>> = _categoryList

    private val _dataLoadingProduct = MutableLiveData(true)
    val dataLoadingProduct: LiveData<Boolean> = _dataLoadingProduct

    private val _remoteProduct = arrayListOf<Products>()
    val remoteProduct = _remoteProduct

    private val _errorProduct = MutableLiveData<String>()
    val errorProduct: LiveData<String> = _errorProduct

    private val _productList = MutableLiveData<List<Products>>()
    val productListLiveData : LiveData<List<Products>> = _productList

    fun getBanner(): MutableList<Banner> {
        var mutableData = mutableListOf<Banner>()
        viewModelScope.launch{
            mutableData = getBannerListUseCase.invoke(Constants.getBanner())
        }

        return mutableData
    }

    fun getCategories() {
        viewModelScope.launch {
            _dataLoadingCategory.postValue(true)
            when (val categoryResult = getCategoriesUseCase.invoke()) {
                is ResultFood.Success -> {
                    _remoteCategory.clear()
                    _remoteCategory.addAll(categoryResult.data)
                    _categoryList.value = _remoteCategory
                }

                is ResultFood.Error -> {
                    _dataLoadingCategory.postValue(false)
                    _errorCategory.postValue(categoryResult.exception.message)
                }
            }
        }
    }

    fun getProducts(categoryId : String) {
        viewModelScope.launch {
            _dataLoadingProduct.postValue(true)
            when (val productResult = getProductsUseCase.invoke(id = categoryId)) {
                is ResultFood.Success -> {
                    _remoteProduct.clear()
                    _remoteProduct.addAll(productResult.data)
                    _productList.value = _remoteProduct
                }

                is ResultFood.Error -> {
                    _dataLoadingProduct.postValue(false)
                    _errorProduct.postValue(productResult.exception.message)
                }
            }
        }
    }
}