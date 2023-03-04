package com.example.retrofit12

import android.app.Application

class App: Application() {

    companion object{
        lateinit var api: CalculateApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitService()
        api = retrofit.getApi()
    }
}

