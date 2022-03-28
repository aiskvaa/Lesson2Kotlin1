package com.aiskvaa.rickandmorty.presentation.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.presentation.ui.adapters.LocationsAdapter
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentLocationsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class   LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationViewModel>(
    R.layout.fragment_locations
) {
    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    private val locationsAdapter = LocationsAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {

        binding.recyclerview.adapter = locationsAdapter
    }

    override fun setupObserver() {
        subscribeToLocations()
    }

    private fun subscribeToLocations() {
        lifecycleScope.launch {
            viewModel.fetchLocations().collectLatest {
                locationsAdapter.submitData(it)
            }
        }
    }

}