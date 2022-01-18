package com.example.swipe_able.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swipe_able.model.ResponseDTO
import com.example.swipe_able.repository.TextRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TextViewModel(private val textRepository: TextRepository):ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            textRepository.getResponseFromApi()
        }
    }
    val text:LiveData<ResponseDTO>
    get() = textRepository.responseText
}