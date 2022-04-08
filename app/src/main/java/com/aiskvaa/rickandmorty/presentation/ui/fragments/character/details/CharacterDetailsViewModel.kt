package com.aiskvaa.rickandmorty.presentation.ui.fragments.character.details

import com.aiskvaa.rickandmorty.base.BaseViewModel
import com.aiskvaa.rickandmorty.data.repositories.CharacterRepository

class CharacterDetailsViewModel  constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {
}