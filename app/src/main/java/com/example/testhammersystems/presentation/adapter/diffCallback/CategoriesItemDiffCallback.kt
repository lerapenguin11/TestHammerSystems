package com.example.testhammersystems.presentation.adapter.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entities.Categories

class CategoriesItemDiffCallback : DiffUtil.ItemCallback<Categories>() {

    override fun areItemsTheSame(oldItem: Categories, newItem: Categories): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Categories, newItem: Categories): Boolean {
        return oldItem == newItem
    }
}