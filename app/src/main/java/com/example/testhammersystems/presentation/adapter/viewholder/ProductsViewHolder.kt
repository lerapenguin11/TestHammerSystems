package com.example.testhammersystems.presentation.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testhammersystems.R

class ProductsViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val nameProduct : TextView = view.findViewById(R.id.tv_name_product)
    val structure : TextView = view.findViewById(R.id.tv_structure)
    val price : TextView = view.findViewById(R.id.tv_price)
    val icon : ImageView = view.findViewById(R.id.ic_product)
}