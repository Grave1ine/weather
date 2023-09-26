package com.example.coursework

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.WeatherPictures
import com.example.coursework.databinding.FragmentDetailsBinding
import com.example.coursework.databinding.FragmentForecastBinding
import com.example.viewModels.viewModelDetails
import com.example.viewModels.viewModelMainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlin.concurrent.thread

//более детальная информация о текущей погоде
@AndroidEntryPoint
class Details : Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private var job: Job? = null

    private inline fun withBinding(block: FragmentDetailsBinding.() -> Unit) {      //чтобы не проверять каждый раз на нулл
        binding?.block()
    }

    private val dataModel: viewModelDetails by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



            dataModel.viewStateDetails.observe(viewLifecycleOwner) {state ->
                Log.i("DETAILS", "State update")
                withBinding{
                  Temp.setTextKeepState(state.temp.toString())
                  Condition.setTextKeepState(state.condition.toString())
                  FeelsLike.setTextKeepState(state.feelsLike.toString())
                  Humidity.setTextKeepState(state.humidity.toString())
                  WindSpeed.setTextKeepState(state.windSpeed.toString())
                  PressureMM.setTextKeepState(state.pressureMM.toString())
                  WindDir.setTextKeepState(state.windDir.toString())
                  Season.setImageResource(state.season?: R.drawable.def)
                  weatherIsNow.setImageResource(state.conditionPicture?: R.drawable.def)

                  Time.setTextKeepState(state.nowTime.toString())
                  Date.setTextKeepState(state.date.toString())
                  SunEnd.setTextKeepState(state.setEnd.toString())
                  Sunrise.setTextKeepState(state.sunrise.toString())
                  MinTemp.setTextKeepState(state.tempMin.toString())
                  MaxTemp.setTextKeepState(state.tempMax.toString())
            }

        }

    }


    override fun onResume() {
        super.onResume()

        dataModel.startTimer()
        job = lifecycleScope.launch {
            while (true) {
                dataModel.goToInetForDetails()
                delay(600_000)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        dataModel.stopTimer()
        job?.cancel()
    }

}

