package com.example.swipe_able.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.swipe_able.repository.TextRepository

class TextViewModelFactory(private val textRepository: TextRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TextViewModel(textRepository) as T
    }

}