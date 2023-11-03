package com.example.testhammersystems.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entities.Banner
import com.example.testhammersystems.R
import com.example.testhammersystems.presentation.adapter.diffCallback.BannerItemDiffCallback
import com.example.testhammersystems.presentation.adapter.viewholder.BannerViewHolder

class BannerAdapter : ListAdapter<Banner, BannerViewHolder>(BannerItemDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)

        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = getItem(position)
        holder.icon.setImageResource(banner.icon)
    }
}