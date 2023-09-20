package com.example.viewState

import com.example.going_online.Forecast

data class viewStateForecast(
    val forecast: List<viewStateForecast1>? = null
)

data class viewStateForecast1(
    val date: String? = null,       //дата

    val tempMorning: Int? = null,      //средняя температура
    val conditionMorning: String? = null,   //погода сейяас

    val tempDay: Int? = null,
    val conditionDay: String? = null,

    val tempEvening: Int? = null,
    val conditionEvening: String? = null,

    val tempNight: Int? = null,
    val conditionNight: String? = null,
)

fun Forecast.toModel(): viewStateForecast1 = viewStateForecast1(
    date = date,
    tempMorning = this.parts?.morning?.temp_avg,
    conditionMorning = this.parts?.morning?.condition,
    tempDay = this.parts?.day?.temp_avg,
    conditionDay = this.parts?.day?.condition,
    tempEvening = this.parts?.evening?.temp_avg,
    conditionEvening = this.parts?.evening?.condition,
    tempNight = this.parts?.night?.temp_avg,
    conditionNight = this.parts?.night?.condition
)
