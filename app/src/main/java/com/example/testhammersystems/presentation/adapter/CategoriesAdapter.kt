package com.example.testhammersystems.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entities.Categories
import com.example.testhammersystems.R
import com.example.testhammersystems.presentation.adapter.diffCallback.CategoriesItemDiffCallback
import com.example.testhammersystems.presentation.adapter.viewholder.CategoriesViewHolder

class CategoriesAdapter : ListAdapter<Categories, CategoriesViewHolder>(
    CategoriesItemDiffCallback()) {

    var onCategoryClickListener : ((Categories) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_not_click, parent, false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categories = getItem(position)
        holder.name.text = categories.name

        holder.itemView.setOnClickListener {
            onCategoryClickListener?.invoke(categories)
        }
    }
}