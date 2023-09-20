package com.example.viewState

import com.google.gson.annotations.SerializedName

data class viewStateMainScreen(
    var date: String? = null,
    var temp: Int? = null,              //температура
    var humidity: Int? = null,          //влажность
    var windSpeed: Int? = null,         //скорость ветра
    var pressureMM: Int? = null,        //давление
    var condition: String? = null,
    var precType: String? = null,
)
