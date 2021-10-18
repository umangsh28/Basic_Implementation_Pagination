package com.example.codingoct18.api

import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.model.ResponseDTOItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    //https://api.tvmaze.com/people?page=1

    @GET("people")
    suspend fun getsearch(@Query("page")pg:Int):List<ResponseDTOItem>

    @GET("people")
    fun addData(@Query("page")pg:Int):Call<ResponseDTO>

}