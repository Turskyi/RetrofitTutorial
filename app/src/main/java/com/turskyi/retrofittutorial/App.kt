package com.turskyi.retrofittutorial

import android.app.Application
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class App : Application() {
    private var retrofit: Retrofit? = null

    companion object {
        var api: UmoriliApi? = null
    }

   override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            /* Base url */
            .baseUrl("https://umorili.herokuapp.com")
            /* Converter needed to convert JSON to object */
            .addConverterFactory(GsonConverterFactory.create())
            .build()
       /* creating object  for requests */
        api = retrofit?.create(UmoriliApi::class.java)
   }
}