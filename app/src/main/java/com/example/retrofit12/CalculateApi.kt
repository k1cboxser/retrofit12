package com.example.retrofit12

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface CalculateApi {

    @GET("getPercentage")
    fun  getPercentage(
        @Query("sname") secondName: String,
        @Query("fname") fileName: String,
        @Header("X-RapidAPI-Key") key: String = "71117c7dcdmshe603db0b45fcc91p168a5ajsne30b0ece2a67",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<CalculateModel>
}