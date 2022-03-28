package com.aiskvaa.rickandmorty.presentation.ui.fragments.episode

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.common.resource.Resource
import com.aiskvaa.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentEpisodesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {
    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodesAdapter()
    override fun setupViews() {
        setupAdapter()

    }

    private fun setupAdapter() {
        binding.recyclerview.adapter = episodeAdapter
    }

    override fun setupObserver() {
        subscribeToEpisodes()
    }

    private fun subscribeToEpisodes() {
        lifecycleScope.launch {
            viewModel.fetchEpisodes().collectLatest {
                episodeAdapter.submitData(it)
            }
        }

    }


}