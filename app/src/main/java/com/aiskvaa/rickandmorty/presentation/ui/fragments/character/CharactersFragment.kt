package com.aiskvaa.rickandmorty.presentation.ui.fragments.character

import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.common.extensions.submitData
import com.aiskvaa.rickandmorty.pagination.PaginationScrollerListener
import com.aiskvaa.rickandmorty.presentation.ui.adapters.CharactersAdapter
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentCharactersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter = CharactersAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserver() {
        subscribeToCharacters()
        subscribeToCharactersLocale()

    }

    private fun setupAdapter() = with(binding.recyclerview) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = characterAdapter

        addOnScrollListener(object :
            PaginationScrollerListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchCharacter() else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToCharacters() {
        viewModel.characterState.observe(viewLifecycleOwner) {
            characterAdapter.submitData(it.results)
        }
    }

    private fun subscribeToCharactersLocale() {
        viewModel.characterLocaleState.observe(viewLifecycleOwner) {
            characterAdapter.submitData(it)
        }
    }

    override fun setupRequest() {
        if (viewModel.characterState.value == null && isOnline()) viewModel.fetchCharacter()
        else viewModel.getCharacters()
    }

    fun isOnline(): Boolean {
        val cm = requireActivity().getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                id
            )
        )
    }
}
