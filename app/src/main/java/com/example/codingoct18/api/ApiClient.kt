package com.example.codingoct18.api

import com.example.codingoct18.model.ResponseDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    //https://api.tvmaze.com/people?page=1

    @GET()
    fun getAll(): Call<ResponseDTO>

}