package com.example.codingoct18.viewmodel

import android.net.DnsResolver
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codingoct18.dataBase.RepoDatabase
import com.example.codingoct18.dataBase.TableeDao
import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.paging.pagingRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModell() : ViewModel() {



    private val repositary=pagingRepo() // for fetching data

    fun Paging()=repositary.getpages()





    val repoDatabase= RepoDatabase()  // for adding data to database
    lateinit var tableeDao: TableeDao

    var mutableLiveData=MutableLiveData<ResponseDTO>()

    fun AddThroughView(page:Int){
        repoDatabase.adddata(page).enqueue(object : Callback<ResponseDTO>{
            override fun onResponse(p0: Call<ResponseDTO>, p1: Response<ResponseDTO>) {
                p1.body()?.let { tableeDao.addT(it) }
                mutableLiveData.value=p1.body()
            }

            override fun onFailure(p0: Call<ResponseDTO>, p1: Throwable) {
                Log.d("Tag",p1.message.toString())
            }

        })
    }







}