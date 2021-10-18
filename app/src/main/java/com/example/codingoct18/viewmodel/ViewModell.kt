package com.example.codingoct18.viewmodel

import android.net.DnsResolver
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.paging.pagingRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModell() : ViewModel() {




    private val repositary=pagingRepo()

    fun Paging()=repositary.getpages()



}