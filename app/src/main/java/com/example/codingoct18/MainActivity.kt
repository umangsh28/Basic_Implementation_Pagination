package com.example.codingoct18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.codingoct18.databinding.ActivityMainBinding
import com.example.codingoct18.viewmodel.ViewModell
import com.example.codingoct18.viewmodel.viewModelfact

class MainActivity : AppCompatActivity() {
      lateinit var viewModell: ViewModell
      lateinit var viewModelfact: viewModelfact

      lateinit var activityMainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        callApi()
    }

    private fun callApi() {
       viewModell=ViewModelProvider(this).get(ViewModell::class.java)
       viewModell.callapibyView(2)


       viewModell.liveData.observe(this,{
           it.apply {

           }
       })
    }
}