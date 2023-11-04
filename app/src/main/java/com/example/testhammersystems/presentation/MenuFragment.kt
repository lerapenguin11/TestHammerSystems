package com.example.testhammersystems.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.domain.entities.Categories
import com.example.testhammersystems.databinding.FragmentMenuBinding
import com.example.testhammersystems.presentation.adapter.BannerAdapter
import com.example.testhammersystems.presentation.adapter.CategoriesAdapter
import com.example.testhammersystems.presentation.adapter.ProductsAdapter
import com.example.testhammersystems.viewmodel.MenuViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<MenuViewModel>()
    private lateinit var bannerAdapter : BannerAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter
    private val productAdapter = ProductsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCategories()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        setBannerRecyclerView()
        bannerAdapter.submitList(viewModel.getBanner())
        setCategoriesRecyclerView()
        setProductRecyclerView()
        categoryClickListener()

        return binding.root
    }

    private fun setProductRecyclerView() {
        viewModel.productListLiveData.observe(viewLifecycleOwner, Observer {productsList ->
            productAdapter.submitList(productsList)
        })
        binding.rvProduct.adapter = productAdapter
    }

    private fun setCategoriesRecyclerView() {
        categoriesAdapter = CategoriesAdapter()
        viewModel.categoryListLiveData.observe(viewLifecycleOwner, Observer {
            categoriesAdapter.submitList(it)
        })
        binding.categoriesLayout.rvCategories.adapter = categoriesAdapter
        viewModel.categoryListLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.getProducts(it[0].id.toString())
        })
    }

    private fun categoryClickListener() {
        categoriesAdapter.onCategoryClickListener = {category ->
            viewModel.getProducts(category.id.toString())
            viewModel.productListLiveData.observe(viewLifecycleOwner, Observer {
                productAdapter.updateData(it)
            })
            binding.rvProduct.adapter = productAdapter
        }
    }

    private fun setBannerRecyclerView() {
        bannerAdapter = BannerAdapter()
        binding.bannersLayout.rvBanner.adapter = bannerAdapter
    }
}