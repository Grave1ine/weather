package com.example.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.example.going_online.*
import com.example.viewState.toModel
import com.example.viewState.viewStateForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject
@HiltViewModel
class viewModelForecast @Inject constructor(private val goToInet: AddressServiceModule) : ViewModel() {

    val _stateForecast: MutableLiveData<viewStateForecast> = MutableLiveData<viewStateForecast>(
        viewStateForecast() // Начальное значение (для обращения внутри)
    )

    val viewStateForecast: LiveData<viewStateForecast> get() = _stateForecast.distinctUntilChanged() //для обращения снаружи

    //private val goToInet = AddressServiceModule().retrofitService()          //создание ретрофита


    suspend fun goToInetForForecast() {
        withContext(Dispatchers.IO) {
            val response = try {
                goToInet.retrofitService().getWeatherForecast()                   //запрос в сеть
            } catch (e: Throwable) {
                Log.e("Forecast", "Error loading data", e)
                null
            }

            if (null != response && response.isSuccessful) {
                val answer: weatherForDays? = response.body()
                val suggestions: List<Forecast?>? = answer?.forecasts

                _stateForecast.postValue(viewStateForecast(
                    forecast = suggestions?.mapNotNull { it?.toModel() }
                ))
            }
        }
    }
}