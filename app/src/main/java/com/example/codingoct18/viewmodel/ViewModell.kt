package com.example.codingoct18.viewmodel

import android.net.DnsResolver
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.repo.Repositary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModell(val repoo:Repositary) : ViewModel() {

    val mutableLiveData= MutableLiveData<ResponseDTO>()
    val liveData:LiveData<ResponseDTO> get() = mutableLiveData

    fun callapibyView(page:Int){
        repoo.getDataByRepo(page).enqueue(object : Callback<ResponseDTO>{
            override fun onResponse(p0: Call<ResponseDTO>, p1: Response<ResponseDTO>) {
               mutableLiveData.value=p1.body()
            }

            override fun onFailure(p0: Call<ResponseDTO>, p1: Throwable) {
                Log.d("Tag",p1.message.toString())
            }
        })
    }


}