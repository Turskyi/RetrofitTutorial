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
            //Базовая часть адреса
            .baseUrl("https://umorili.herokuapp.com")
            //Конвертер, необходимый для преобразования JSON'а в объекты
            .addConverterFactory(GsonConverterFactory.create())
            .build()
       //Создаем объект, при помощи которого будем выполнять запросы
        api = retrofit!!.create(UmoriliApi::class.java)
   }
}