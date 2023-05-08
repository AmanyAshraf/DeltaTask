package com.example.deltatask.domain.repository

import com.example.deltatask.data.network.NewsApi
import com.example.deltatask.data.network.api_key
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(
    private val api: NewsApi
){
    suspend fun getNews() = withContext(Dispatchers.IO) {
        api.getEverything("tesla", api_key )
    }
     //   val list = api.getEverything("tesla", api_key)



}