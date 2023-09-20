package com.example.going_online

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {

    @GET("forecast?lat=59.9386&lon=30.3141&lang=ru_RU&limit=1&hours=false&extra=false")
    suspend fun getWeatherMineScreen(): Response<WeatherMineScreen>
    //@Body query: Query думаю не нужно, мы же ничего не передаем серверу, только берем

    @GET("forecast?lat=59.9386&lon=30.3141&lang=ru_RU&limit=7&hours=false&extra=false")
    suspend fun getWeatherForecast(): Response<weatherForDays>

    @GET("forecast?lat=59.9386&lon=30.3141&lang=ru_RU&limit=1&hours=false&extra=false")
    suspend fun getWeatherDetails(): Response<WeatherDetails>

}
//@body - передавать объект query , что в параметрах в body запроса
//Result надо обрабатывать исключение  List не надо
//POST   постоянная часть ссылки -
// переменная часть ссылки указывается в аннотации - /suggestions/api/4_1/rs/suggest/address
