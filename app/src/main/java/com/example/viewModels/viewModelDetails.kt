package com.example.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import com.example.WeatherPictures
import com.example.going_online.*
import com.example.viewState.toModel
import com.example.viewState.viewStateDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.Time
import java.time.*
import java.time.format.DateTimeFormatter

class viewModelDetails : ViewModel() {

    val _stateDetails: MutableLiveData<viewStateDetails> = MutableLiveData<viewStateDetails>(
        viewStateDetails() // Начальное значение (для обращения внутри)
    )

    val viewStateDetails: LiveData<viewStateDetails> get() = _stateDetails.distinctUntilChanged() //для обращения снаружи

    private val goToInet = AddressServiceModule().retrofitService()          //создание ретрофита

     fun _Time() {
            _stateDetails.postValue(
                viewStateDetails(
                    nowTime = DateTimeFormatter.ofPattern("HH:mm")
                        .format(ZonedDateTime.now(ZoneId.of("Europe/Moscow"))).toString(),
                )
            )
    }

    suspend fun goToInetForDetails() {
        withContext(Dispatchers.IO) {
            val response = try {
                goToInet.getWeatherDetails()                   //запрос в сеть
            } catch (e: Throwable) {
                Log.e("Main", "Error loading data", e)
                null
            }

            if (null != response && response.isSuccessful) {
                val answer: WeatherDetails? = response.body()
                val suggestions: FactDetails? = answer?.fact

                val listData: List<ForecastForDetails?>?=answer?.fact?.forecastsDetails

                // Первый прогноз в списке поля forecasts
                val forecast = answer?.forecasts?.firstOrNull()

                _stateDetails.postValue(
                    viewStateDetails(
                        temp =suggestions?.temp,
                        feelsLike =suggestions?.feelsLike,
                        humidity =suggestions?.humidity,
                        condition =WeatherPictures.weatherToRUS[suggestions?.condition],
                        conditionPicture=WeatherPictures.weatherPicturesMap64[suggestions?.condition],
                        windSpeed =suggestions?.windSpeed,
                        windDir =WeatherPictures.windDir[suggestions?.windDir],
                        pressureMM =suggestions?.pressureMM,
                        season = WeatherPictures.season[suggestions?.season],
                        tempMax = forecast?.parts?.day?.tempMax,
                        tempMin = forecast?.parts?.night?.tempMin,
                        sunrise = forecast?.sunrise,
                        setEnd = forecast?.sunset,
                        date = WeatherPictures.weekShort[LocalDate.parse(forecast?.date , DateTimeFormatter.ofPattern("yyyy-MM-dd")).dayOfWeek.toString().lowercase()],
                        listData =listData?.mapNotNull { it?.toModel() }
                    )
                )
            }
        }
    }

}
//val temp: Int? = null,              //температура
//val feelsLike: Int? = null,        //ощущается как
//val humidity: Int? = null,          //влажность
//val condition: String? = null,      //погодные условия
//val phenomCondition: String? = null,//доп описания (туман, пыль...)
//val windSpeed: Double? = null,         //скорость ветра
//val windDir: String? = null,         //направление ветра
//val pressureMM: Int? = null,        //давление
//val season: String? = null,         //сезон