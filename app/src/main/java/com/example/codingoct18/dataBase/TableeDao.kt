package com.example.codingoct18.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.codingoct18.model.ResponseDTOItem


@Dao
interface TableeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  addT(responseDTOItem: List<ResponseDTOItem>)
}
