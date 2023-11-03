package com.example.testhammersystems.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Banner
import com.example.domain.usecase.GetBannerListUseCase
import com.example.testhammersystems.Constants
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getBannerListUseCase: GetBannerListUseCase
) : ViewModel(){

    fun getBanner(): MutableList<Banner> {
        var mutableData = mutableListOf<Banner>()
        viewModelScope.launch{
            mutableData = getBannerListUseCase.invoke(Constants.getBanner())
        }

        return mutableData
    }
}