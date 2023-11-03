package com.example.domain.repository

import com.example.domain.entities.Banner

interface MenuRepository {

    fun getBannerList(list : List<Banner>) : List<Banner>
}