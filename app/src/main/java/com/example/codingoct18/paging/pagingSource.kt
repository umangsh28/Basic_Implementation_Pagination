package com.example.codingoct18.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.model.ResponseDTOItem
import com.example.codingoct18.network.network
import java.lang.Exception

class pagingSource :PagingSource<Int,ResponseDTOItem>(){

    private val api=network.getDataByNetwork()

    override fun getRefreshKey(state: PagingState<Int, ResponseDTOItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseDTOItem> {
        val pagenum=params.key?:1
        val responseDTO=api.getsearch(pagenum)
        val responseDTO1:List<ResponseDTOItem> = responseDTO

        return try{
            LoadResult.Page(
                data = responseDTO1,
                prevKey = null,
                nextKey = if(responseDTO1.isEmpty()) null else pagenum+1
            )
        }catch (exception :Exception){
            LoadResult.Error(exception)
        }

    }
}