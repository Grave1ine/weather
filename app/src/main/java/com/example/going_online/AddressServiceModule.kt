package com.example.going_online

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AddressServiceModule @Inject constructor() {

    private fun createClient() = OkHttpClient.Builder()       //через это приложение идет в сеть?
        .addInterceptor(AuthInterceptor())                    //добавляем отслеживалку запросов?
        .build()


    fun retrofitService() = Retrofit.Builder()                //сам ретрофит
        .client(createClient())                               //проброска клиента
        .baseUrl(BASE_URL)                                    //проброска адреса
        .addConverterFactory(GsonConverterFactory.create())   //конвертор фабрика для работы с Json Просто преобразователь класс-текст-класс
        .build()
        .create(WeatherService::class.java)

    companion object {
        private const val BASE_URL = "https://api.weather.yandex.ru/v2/"    //основная часть адреса
    }

}