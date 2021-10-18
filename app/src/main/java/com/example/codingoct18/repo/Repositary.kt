package com.example.codingoct18.repo

import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.network.network
import retrofit2.Call

class Repositary  {

    fun getDataByRepo(page:Int): Call<ResponseDTO> {
        return network.getDataByNetwork().getdataByApi(page)
    }
}