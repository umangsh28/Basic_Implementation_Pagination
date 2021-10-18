package com.example.codingoct18.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.codingoct18.R
import com.example.codingoct18.databinding.ItemDesignBinding
import com.example.codingoct18.model.ResponseDTO
import com.example.codingoct18.model.ResponseDTOItem

class pagingadapter : PagingDataAdapter<ResponseDTOItem,holder>(diff){

    companion object{
        val diff=object : DiffUtil.ItemCallback<ResponseDTOItem>(){
            override fun areItemsTheSame(oldItem: ResponseDTOItem, newItem: ResponseDTOItem): Boolean {
               return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: ResponseDTOItem, newItem: ResponseDTOItem): Boolean {
                return oldItem.id==newItem.id && oldItem.name.equals(newItem.name)
            }

        }
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        val res:ResponseDTOItem=getItem(position)!!
        holder.setdata(res)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val itemDesignBinding :ItemDesignBinding =DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_design,parent,false)
        return holder(itemDesignBinding)
    }


}