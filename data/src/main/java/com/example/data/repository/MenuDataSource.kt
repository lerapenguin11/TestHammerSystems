package com.example.data.repository

import com.example.domain.entities.Banner

interface MenuDataSource {

    fun getBannerList(list : MutableList<Banner>) : MutableList<Banner>
}