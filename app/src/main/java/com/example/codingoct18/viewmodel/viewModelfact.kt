package com.example.codingoct18.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codingoct18.repo.Repositary

class viewModelfact(val repo :Repositary) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(p0: Class<T>): T {
       return ViewModell(repo) as T
    }

}