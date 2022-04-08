package com.aiskvaa.rickandmorty.presentation.ui.fragments.episode

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.common.extensions.submitData
import com.aiskvaa.rickandmorty.pagination.PaginationScrollerListener
import com.aiskvaa.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentEpisodesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(
    R.layout.fragment_episodes
) {

    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModel()
    private val episodesAdapter = EpisodesAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserver() {
        subscribeToEpisodes()
        subscribeToEpisodesLocale()
    }

    private fun setupAdapter() = with(binding.recyclerview) {
        adapter = episodesAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager

        addOnScrollListener(object :
            PaginationScrollerListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchEpisodes()
                else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToEpisodes() {
        viewModel.episodesState.observe(viewLifecycleOwner) {
            episodesAdapter.submitData(it.results)
        }
    }

    private fun subscribeToEpisodesLocale() {
        viewModel.episodesLocaleState.observe(viewLifecycleOwner) {
            episodesAdapter.submitData(it)
        }
    }

    override fun setupRequest() {
        if (viewModel.episodesState.value == null && isOnline()) viewModel.fetchEpisodes()
        else viewModel.getEpisodes()
    }

    fun isOnline(): Boolean {
        val cm =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}