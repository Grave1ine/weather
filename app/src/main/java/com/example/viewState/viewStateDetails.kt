package com.example.viewState

import com.example.going_online.ForecastForDetails
import java.time.LocalDate

data class viewStateDetails(
    val temp: Int? = null,              //температура
    val feelsLike: Int? = null,        //ощущается как
    val humidity: Int? = null,          //влажность
    val condition: String? = null,      //погодные условия
    val conditionPicture : Int? = null,
    //val phenomCondition: String? = null,//доп описания (туман, пыль...)
    val windSpeed: Double? = null,         //скорость ветра
    val windDir: String? = null,         //направление ветра
    val pressureMM: Int? = null,        //давление
    val season: Int? = null,         //сезон

    val tempMax: Int? = null,   //максимальная темп за день
    val tempMin: Int? = null,   //минимальная
    val sunrise: String? = null, //восход
    val setEnd: String? = null, //закат
    val date: String? = null,
    val nowTime: String? = null,

    val listData: List<_forecasts>? = null,
    )

data class _forecasts(
    val tempMax: Int? = null,   //максимальная темп за день
    val tempMin: Int? = null,   //минимальная
    val sunrise: String? = null, //восход
    val setEnd: String? = null, //закат
    val date: String? = null,
)

fun ForecastForDetails.toModel(): _forecasts = _forecasts(
    sunrise = this.sunrise,
    setEnd = this.sunset,
    tempMax = this.parts.day.tempMax,
    tempMin = this.parts.night.tempMin,
    date = this.date,
)