package com.aiskvaa.rickandmorty.presentation.ui.fragments.location

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.common.extensions.submitData
import com.aiskvaa.rickandmorty.pagination.PaginationScrollerListener
import com.aiskvaa.rickandmorty.presentation.ui.adapters.LocationsAdapter
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentLocationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationViewModel>(
    R.layout.fragment_locations
) {
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationsAdapter()

    override fun setupObserver() {
        subscribeToLocations()
        subscribeToLocationLocale()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recyclerview) {
        adapter = locationAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager

        addOnScrollListener(object :
            PaginationScrollerListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchLocation()
                else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToLocations() {
        viewModel.locationsState.observe(viewLifecycleOwner) {
            locationAdapter.submitData(it.results)

        }
    }

    private fun subscribeToLocationLocale() {
        viewModel.episodesLocaleState.observe(viewLifecycleOwner) {
            locationAdapter.submitData(it)
        }
    }

    override fun setupRequest() {
        if (viewModel.locationsState.value == null && isOnline()) viewModel.fetchLocation()
        else viewModel.getLocation()
    }

    fun isOnline(): Boolean {
        val cm =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}