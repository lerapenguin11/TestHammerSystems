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
    private var checkType : Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_DISABLE -> R.layout.item_categories_not_click
            VIEW_TYPE_ENABLE -> R.layout.item_categories_click
            else -> throw java.lang.RuntimeException("Unknow view type: $viewType")
        }

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

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if(checkType){
            VIEW_TYPE_ENABLE
        } else{
            VIEW_TYPE_DISABLE
        }
    }

    companion object{
        const val VIEW_TYPE_ENABLE = 100
        const val VIEW_TYPE_DISABLE = 101
        const val MAX_POOL_SIZE = 15
    }
}