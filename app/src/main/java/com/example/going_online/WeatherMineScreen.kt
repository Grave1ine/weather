package com.example.going_online

import com.google.gson.annotations.SerializedName



data class WeatherMineScreen(    //погода главного экрана
    val fact: Fact
)
 data class Fact(                //компонент ответа
     val temp: Int,              //температура
     val humidity: Int,          //влажность
     @SerializedName("wind_speed")
     val windSpeed: Double,         //скорость ветра
     @SerializedName("pressure_mm")
     val pressureMM: Int,        //давление
     val condition: String,
     @SerializedName("prec_type")
     val precType: Int,

)

//########################################################################   Forecast

data class weatherForDays(       //погода почасовая на 7 дней
    val forecasts: List<Forecast?>? = null
)

data class Forecast(
    val date: String? = null,        //дата
    val parts: Parts? = null,        //утро вечер день ночь
)

data class Parts(                    //утро вечер день ночь
    val morning: Morning? = null,
    val day: Day? = null,
    val evening: Evening? = null,
    val night: Night? = null
)

data class Morning(
    val temp_avg: Int? = null,       //средняя температура
    val condition: String? = null,   //погода сейяас
)

data class Day(
    val temp_avg: Int? = null,
    val condition: String? = null,
)
data class Evening(
    val temp_avg: Int? = null,
    val condition: String? = null,
)

data class Night(
    val temp_avg: Int? = null,
    val condition: String? = null,
)

//########################################################################   Details

data class WeatherDetails(    //погода главного экрана
    val fact: FactDetails,
    val forecasts: List<ForecastForDetails>?
)

data class FactDetails(
    val temp: Int,              //температура
    @SerializedName("feels_like")
    val feelsLike: Int,        //ощущается как
    val humidity: Int,          //влажность
    val condition: String,      //погодные условия
    @SerializedName("phenom_condition")
    val phenomCondition: String,//доп описания (туман, пыль...)
    @SerializedName("wind_speed")
    val windSpeed: Double,         //скорость ветра
    @SerializedName("wind_dir")
    val windDir: String,         //направление ветра
    @SerializedName("pressure_mm")
    val pressureMM: Int,        //давление
    val season: String,         //сезон
    val forecastsDetails: List<ForecastForDetails>,

)

data class ForecastForDetails(

    @SerializedName("rise_begin")
    val sunrise: String, //восход
    @SerializedName("set_end")
    val sunset: String, //закат
    val parts: PartsDetails,
    val date: String,
)

data class PartsDetails(                    //утро вечер день ночь
    val day: DayDetails,
    val night: NightDetails,
)

data class DayDetails(
    @SerializedName("temp_max")
    val tempMax: Int,   //максимальная темп за день
)
data class NightDetails(
    @SerializedName("temp_min")
    val tempMin: Int,   //минимальная темп за день
)



//Код расшифровки погодного описания. Возможные значения condition:
//clear — ясно.
//partly-cloudy — малооблачно.
//cloudy — облачно с прояснениями.
//overcast — пасмурно.
//light-rain — небольшой дождь.
//rain — дождь.
//heavy-rain — сильный дождь.
//showers — ливень.
//wet-snow — дождь со снегом.
//light-snow — небольшой снег.
//snow — снег.
//snow-showers — снегопад.
//hail — град.
//thunderstorm — гроза.
//thunderstorm-with-rain — дождь с грозой.
//thunderstorm-with-hail — гроза с градом.