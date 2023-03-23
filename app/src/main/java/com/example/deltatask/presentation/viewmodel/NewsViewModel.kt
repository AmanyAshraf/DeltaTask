package com.example.deltatask.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deltatask.domain.repository.DataRepository
import com.example.deltatask.data.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel  :ViewModel() {
    val dataRepository= DataRepository()
    private var _mutableResponse = MutableLiveData<News>()
    val response: LiveData<News> = _mutableResponse

    init {
        getData()
    }
    fun getData(){
        dataRepository.list.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                _mutableResponse.value=response.body()
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
            }

        })
    }
}