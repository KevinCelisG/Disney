package com.example.disney.ui.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disney.domain.model.Character
import com.example.disney.domain.useCases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var listCharactersMutable = MutableLiveData<Result<List<Character>>>()

    fun loadCharacters() {
        viewModelScope.launch {
            isLoading.postValue(true)
            listCharactersMutable.postValue(getCharactersUseCase.invoke())
            isLoading.postValue(false)
        }
    }
}