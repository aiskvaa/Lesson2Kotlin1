package com.aiskvaa.rickandmorty.presentation.ui.fragments.character.details

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aiskvaa.rickandmorty.base.BaseFragment
import com.aiskvaa.rickandmorty.common.extensions.setImage
import com.aiskvaa.rickandmorty.common.resource.Resource
import com.example.lesson2kotlin2.R
import com.example.lesson2kotlin2.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>(
        R.layout.fragment_character_details
    ) {
    override val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()


    override fun setupViews() {
    }


    override fun setupObserver() {
        subscribeToCharacters()
    }


    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchSingleCharacter(args.characterId).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("GayPop", "Loading ")
                    }

                    is Resource.Error -> {
                        Log.e("GayPop", it.message.toString())


                    }
                    is Resource.Success -> {
                        binding.tvCharacter.text = it.data?.name
                        it.data?.image?.let { it1 -> binding.imCharacter.setImage(it1) }
                    }
                }
            }

        }
    }


}