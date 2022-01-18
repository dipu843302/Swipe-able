package com.example.swipe_able.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.swipe_able.api.API
import com.example.swipe_able.model.ResponseDTO
import com.google.gson.*



class TextRepository(private val api: API) {

    private val TextLiveData =MutableLiveData<ResponseDTO>()
    val responseText:LiveData<ResponseDTO>
    get() = TextLiveData

    private val gson = Gson()

    suspend fun getResponseFromApi(){
        val textApiResponse=api.getData().body()
        val data = textApiResponse?.substring(1,textApiResponse.length)
        if (textApiResponse!=null){
            val reponse  = gson.fromJson<ResponseDTO>(data,object:TypeToke)
            TextLiveData.postValue(textApiResponse.body())
        }
    }
}