package com.example.testhammersystems.presentation.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testhammersystems.R

class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val name : TextView = view.findViewById(R.id.tv_name_categories)
}