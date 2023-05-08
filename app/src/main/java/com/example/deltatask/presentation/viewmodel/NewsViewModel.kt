package com.example.deltatask.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deltatask.domain.repository.DataRepository
import com.example.deltatask.data.model.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val dataRepository: DataRepository

) :ViewModel() {
    private var _mutableResponse = MutableLiveData<News>()
    val response: LiveData<News> = _mutableResponse

    init {
        getData()
    }

    fun getData(){
       /* dataRepository.list.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                _mutableResponse.value=response.body()
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
            }

        })*/
        viewModelScope.launch {
            _mutableResponse.value=  dataRepository.getNews()
        }
    }
}