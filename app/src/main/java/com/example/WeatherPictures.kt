package com.example

import com.example.coursework.R

object WeatherPictures {
     val weatherToRUS = mapOf(
        "clear" to "ясно",
        "partly-cloudy" to "малооблачно",
        "cloudy" to "облачно с прояснениями",
        "overcast" to "пасмурно",
        "light-rain" to "небольшой дождь",
        "rain" to "дождь",
        "heavy-rain" to "сильный дождь",
        "showers" to "ливень",
        "wet-snow" to "дождь со снегом",
        "light-snow" to "небольшой снег",
        "snow" to "снег",
        "snow-showers" to "снегопад",
        "hail" to "град",
        "thunderstorm" to "гроза",
        "thunderstorm-with-rain" to "дождь с грозой",
        "thunderstorm-with-hail" to "гроза с градом",
    )


   val weatherPicturesMap = mapOf(
      "clear" to R.drawable.sun64,
      "partly-cloudy" to R.drawable.cloud64,
      "cloudy" to R.drawable.cloud64,
      "overcast" to R.drawable.cloud64,
      "light-rain" to R.drawable.rain64,
      "rain" to R.drawable.rain64,
      "heavy-rain" to R.drawable.rain64,
      "showers" to R.drawable.rain64,
      "wet-snow" to R.drawable.snowfall64,
      "light-snow" to R.drawable.snowfall64,
      "snow" to R.drawable.snowfall64,
      "snow-showers" to R.drawable.snowfall64,
      "hail" to R.drawable.hail64,
      "thunderstorm" to R.drawable.storm64,
      "thunderstorm-with-rain" to R.drawable.storm64,
      "thunderstorm-with-hail" to R.drawable.storm64,
      "default" to R.drawable.defolt_icon,
   )


   val weatherPicturesMap64 = mapOf(
      "clear" to R.drawable.clear,
      "partly-cloudy" to R.drawable.partly_cloudy,
      "cloudy" to R.drawable.cloudy,
      "overcast" to R.drawable.overcast,
      "light-rain" to R.drawable.light_rain,
      "rain" to R.drawable.rain,
      "heavy-rain" to R.drawable.heavy_rain,
      "showers" to R.drawable.heavy_rain,
      "wet-snow" to R.drawable.wet_snow,
      "light-snow" to R.drawable.light_snow,
      "snow" to R.drawable.snow,
      "snow-showers" to R.drawable.snow_showers,
      "hail" to R.drawable.hail,
      "thunderstorm" to R.drawable.thunderstorm,
      "thunderstorm-with-rain" to R.drawable.thunderstorm,
      "thunderstorm-with-hail" to R.drawable.thunderstorm_with_hail,
      "default" to R.drawable.defolt_icon,
   )


   val week = mapOf(
      "monday" to "понедельник",
      "tuesday" to "вторник",
      "wednesday" to "среда",
      "thursday" to "четверг",
      "friday" to "пятница",
      "saturday" to "суббота",
      "sunday" to "воскресенье"
   )

   val weekShort = mapOf(
      "monday" to "пн",
      "tuesday" to "вт",
      "wednesday" to "ср",
      "thursday" to "чт",
      "friday" to "пт",
      "saturday" to "ст",
      "sunday" to "вс"
   )

   val precType = mapOf(
      0 to "без осадков",
      1 to "дождь",
      2 to "дождь со снегом",
      3 to "снег",
      4 to "град",
   )

   val season = mapOf(
      "summer" to R.drawable.summer,
      "autumn" to R.drawable.autumn,
      "winter" to R.drawable.winte,
      "spring" to R.drawable.spring,
   )

   val windDir = mapOf(
   "nw" to "северо-западное",
   "n" to "северное",
   "ne" to "северо-восточное",
   "e" to "восточное",
   "se" to "юго-восточное",
   "s" to "южное",
   "sw" to "юго-западное",
   "w" to "западное",
   "c" to "штиль",
   )

}

//clear — ясно.
//partly-cloudy — малооблачно.
//cloudy — облачно с прояснениями.
//overcast — пасмурно.
//light-rain — небольшой дождь.
//rain — дождь.
//heavy-rain — сильный дождь.
//showers — ливень. то же что и сильный дождь
//wet-snow — дождь со снегом.
//light-snow — небольшой снег.
//snow — снег.
//snow-showers — снегопад.
//hail — град.
//thunderstorm — гроза.
//thunderstorm-with-rain — дождь с грозой. тоже что и thunderstorm
//thunderstorm-with-hail — гроза с градом.