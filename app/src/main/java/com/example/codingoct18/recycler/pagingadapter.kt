package com.example.codingoct18.recycler

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.codingoct18.model.ResponseDTO

class pagingadapter  : PagingDataAdapter<ResponseDTO,holder>(){

    companion object{
        val diff=object : DiffUtil.ItemCallback<ResponseDTO>(){
            override fun areItemsTheSame(oldItem: ResponseDTO, newItem: ResponseDTO): Boolean {
               return oldItem
            }

            override fun areContentsTheSame(oldItem: ResponseDTO, newItem: ResponseDTO): Boolean {
                TODO("Not yet implemented")
            }

        }
    }


}