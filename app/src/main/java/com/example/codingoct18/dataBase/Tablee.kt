package com.example.codingoct18.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tablee")
data class Tablee(
    @ColumnInfo(name ="name") var name:String,
    @ColumnInfo(name="birthdate") var birth:String,
    @ColumnInfo(name="deathdate") var death:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}