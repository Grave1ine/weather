package com.example.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.example.WeatherPictures
import com.example.going_online.AddressServiceModule
import com.example.going_online.Fact
import com.example.going_online.WeatherMineScreen
import com.example.viewState.viewStateMainScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
open class viewModelMainScreen @Inject constructor(private val goToInet: AddressServiceModule): ViewModel() {

    val _stateMainScreen: MutableLiveData<viewStateMainScreen> = MutableLiveData<viewStateMainScreen>(
        viewStateMainScreen() // Начальное значение (для обращения внутри)
    )

    val viewStateMainScreen: LiveData<viewStateMainScreen> get() = _stateMainScreen.distinctUntilChanged() //для обращения снаружи

    //private val goToInet = AddressServiceModule().retrofitService()          //создание ретрофита


    suspend fun goToInetForMainScreen() {
        withContext(Dispatchers.IO) {
            val response = try {
                goToInet.retrofitService().getWeatherMineScreen()                   //запрос в сеть
            } catch (e: Throwable) {
                Log.e("Main", "Error loading data", e)
                null
            }

            if (null != response && response.isSuccessful) {
                val answer: WeatherMineScreen? = response.body()
                val suggestions: Fact? = answer?.fact

                _stateMainScreen.postValue(viewStateMainScreen(
                    date = DateTimeFormatter.ofPattern("dd.MM").format(ZonedDateTime.now(ZoneId.of("Europe/Moscow"))),
                    temp=suggestions?.temp,
                    humidity=suggestions?.humidity,
                    windSpeed=suggestions?.humidity,
                    pressureMM=suggestions?.pressureMM,
                    condition=suggestions?.condition,
                    precType = WeatherPictures.precType[suggestions?.precType],

                ))
            }
        }
    }

}