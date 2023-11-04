package com.example.testhammersystems.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.domain.entities.Products
import com.example.testhammersystems.R
import com.example.testhammersystems.presentation.adapter.diffCallback.ProductsItemDiffCallback
import com.example.testhammersystems.presentation.adapter.viewholder.ProductsViewHolder

class ProductsAdapter : ListAdapter<Products, ProductsViewHolder> (
    ProductsItemDiffCallback()
){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)

        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = getItem(position)
        holder.nameProduct.text = product.name
        holder.structure.text = product.ingredients
        //исправить
        holder.price.setText("от ${product.price} р")

        val url = "http://192.168.43.78:3333/files/${product.image}"

        Glide.with(holder.itemView)
            .load(url)
            .into(holder.icon)
    }

    fun updateData(newData: List<Products>) {
        submitList(newData)
        notifyDataSetChanged()
    }
}