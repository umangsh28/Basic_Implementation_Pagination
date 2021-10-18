package com.example.codingoct18.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class pagingRepo {

    fun getpages()= Pager(config = PagingConfig(pageSize = 10),pagingSourceFactory = {pagingSource()}).liveData

}