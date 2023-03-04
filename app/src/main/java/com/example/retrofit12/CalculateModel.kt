package com.example.retrofit12

import com.google.gson.annotations.SerializedName


data class CalculateModel (
     @SerializedName("fname")
     val fileNameMap: String,
     @SerializedName("sname")
     val secondName:String,
     val percentage: String,
     val result: String,

)