package com.example.codingoct18.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codingoct18.databinding.ItemDesignBinding
import com.example.codingoct18.model.ResponseDTOItem

class holder(private val itemDesignBinding: ItemDesignBinding):RecyclerView.ViewHolder(itemDesignBinding.root) {

    fun setdata(responseDTOItem: ResponseDTOItem){


        itemDesignBinding.dataa=responseDTOItem
        if(responseDTOItem.birthday!=null || responseDTOItem.deathday!=null){
            itemDesignBinding.birth.visibility=View.VISIBLE
            itemDesignBinding.death.visibility=View.VISIBLE
        }else{
            itemDesignBinding.birth.visibility=View.INVISIBLE
            itemDesignBinding.death.visibility=View.INVISIBLE
        }
        Glide.with(itemDesignBinding.img1).load(responseDTOItem.image.original).into(itemDesignBinding.img1)

    }

}