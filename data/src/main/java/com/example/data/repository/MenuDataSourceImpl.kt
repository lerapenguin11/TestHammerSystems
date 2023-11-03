package com.example.data.repository

import com.example.domain.entities.Banner

class MenuDataSourceImpl : MenuDataSource {

    override fun getBannerList(list: MutableList<Banner>): MutableList<Banner> {
        val bannerList = mutableListOf<Banner>()

        for (i in list){
            val icon = i.icon
            val id = i.id

            val listLetterModel = Banner(icon = icon, id = id)

            bannerList.add(listLetterModel)
        }

        return bannerList
    }
}