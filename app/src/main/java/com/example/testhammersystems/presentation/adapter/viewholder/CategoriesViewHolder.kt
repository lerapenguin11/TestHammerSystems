package com.example.testhammersystems.presentation.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testhammersystems.R
import kotlin.coroutines.Continuation

class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val name : TextView = view.findViewById(R.id.tv_name_categories)
    val box : ConstraintLayout = view.findViewById(R.id.box_category)
}