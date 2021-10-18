package com.example.codingoct18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        callApi()



    }



    private fun callApi() {
       viewModell=ViewModelProvider(this).get(ViewModell::class.java)
        setRecycler()
        pagingadapter

       viewModell.Paging().observe(this,{
           it.apply {
               CoroutineScope(Main).launch {
                   pagingadapter.submitData(it)

               }
           }
       })
    }

    private fun setRecycler() {

        pagingadapter= pagingadapter()
        val linearLayoutManager=LinearLayoutManager(this)

        activityMainBinding.recycler.apply {
            layoutManager=linearLayoutManager
            this.adapter=pagingadapter
        }
    }
}