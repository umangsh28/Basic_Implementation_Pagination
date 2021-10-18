package com.example.codingoct18.network

import com.example.codingoct18.api.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object network {

    public const val burl=" https://api.tvmaze.com/"

    fun getDataByNetwork() :ApiClient{
        val builder=Retrofit.Builder()
            .baseUrl(burl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(ApiClient::class.java)
    }
}