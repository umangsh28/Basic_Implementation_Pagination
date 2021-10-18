package com.example.codingoct18.dataBase

import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.model.ResponseDTOItem
import com.example.codingoct18.network.network
import retrofit2.Call

class RepoDatabase {

    fun adddata(page:Int): Call<ResponseDTO> {
        return network.getDataByNetwork().addData(page)
    }
}