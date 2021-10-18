package com.example.codingoct18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingoct18.dataBase.ViewModelDatabase
import com.example.codingoct18.databinding.ActivityMainBinding
import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.model.ResponseDTOItem
import com.example.codingoct18.recycler.pagingadapter
import com.example.codingoct18.viewmodel.ViewModell
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
      lateinit var viewModell: ViewModell


      lateinit var activityMainBinding: ActivityMainBinding

      lateinit var pagingadapter: pagingadapter




      var datalist= mutableListOf<ResponseDTO>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModell=ViewModelProvider(this).get(ViewModell::class.java)



        setRecycler()




        viewModell.Paging().observe(this,{
            it.apply {
                CoroutineScope(Main).launch {
                    pagingadapter.submitData(it)

                }
            }
        })



        addingdatatodatabase()
    }




    private fun setRecycler() {

        pagingadapter= pagingadapter()
        val linearLayoutManager=GridLayoutManager(this,1)

        activityMainBinding.recycler.apply {
            layoutManager=linearLayoutManager
            this.adapter=pagingadapter
        }
    }


    private fun addingdatatodatabase() {
        viewModell.mutableLiveData.observe(this,{
            datalist.addAll(listOf(it))

        })
    }

}