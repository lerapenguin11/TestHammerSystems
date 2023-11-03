package com.example.testhammersystems

import com.example.domain.entities.Banner

object Constants {

    fun getBanner() : MutableList<Banner>{
        var bannerList = mutableListOf<Banner>()

        val banner1 = Banner(0, R.drawable.banner1)
        bannerList.add(banner1)

        val banner2 = Banner(1, R.drawable.banner2)
        bannerList.add(banner2)

        return bannerList
    }
}