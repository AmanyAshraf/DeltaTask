package com.example.deltatask.data.network

import com.example.deltatask.data.model.News
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything")
    fun getEverything(@Query("q")query:String, @Query("apiKey") apiKey:String) : Call<News>
}
val httpLogging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

val client = OkHttpClient().newBuilder()
    .addInterceptor(httpLogging)
    .build()


val retrofit = Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

val service = retrofit.create(NewsApi::class.java)