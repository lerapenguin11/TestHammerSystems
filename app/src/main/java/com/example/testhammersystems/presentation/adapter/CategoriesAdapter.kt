package com.example.testhammersystems.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Categories
import com.example.testhammersystems.R
import com.example.testhammersystems.presentation.adapter.diffCallback.CategoriesItemDiffCallback
import com.example.testhammersystems.presentation.adapter.viewholder.CategoriesViewHolder

class CategoriesAdapter : ListAdapter<Categories, CategoriesViewHolder>(
    CategoriesItemDiffCallback()) {

    var onCategoryClickListener : ((Categories) -> Unit)? = null
    private var rowIndex = -1
    private var previouslySelectedCategory: View? = null
    private var check = false

    private var selectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_DISABLE -> R.layout.item_categories_not_click
            VIEW_TYPE_ENABLE -> R.layout.item_categories_click
            else -> throw java.lang.RuntimeException("Unknown view type: $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return CategoriesViewHolder(view)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: CategoriesViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val categories = getItem(position)
        holder.name.text = categories.name

        holder.itemView.setOnClickListener {
            rowIndex = position
            onCategoryClickListener?.invoke(categories)
            val previousSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if (position == selectedPosition){
            holder.box.setBackgroundResource(R.drawable.bg_categories_click)
        }else {
            holder.box.setBackgroundResource(R.drawable.bg_categories_not)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == selectedPosition) VIEW_TYPE_ENABLE else VIEW_TYPE_DISABLE
    }

    companion object{
        const val VIEW_TYPE_ENABLE = 100
        const val VIEW_TYPE_DISABLE = 101
        const val MAX_POOL_SIZE = 15
    }
}