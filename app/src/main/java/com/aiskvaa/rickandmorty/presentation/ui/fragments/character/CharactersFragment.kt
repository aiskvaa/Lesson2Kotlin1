package com.aiskvaa.rickandmorty.presentation.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.presentation.ui.adapters.CharactersAdapter
import com.aiskvaa.rickandmorty.presentation.ui.adapters.ProgressBarLoader
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharactersAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.adapter = characterAdapter.withLoadStateFooter(
            footer = ProgressBarLoader {characterAdapter.retry()}
        )
    }

    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

}