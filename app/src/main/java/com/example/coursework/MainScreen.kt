package com.example.coursework

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coursework.databinding.FragmentMainScreenBinding
import com.example.viewModels.viewModelMainScreen
import kotlinx.coroutines.*
import java.sql.Time
import java.util.*
import kotlin.concurrent.schedule

//основной экран
//@AndroidEntryPoint
class MainScreen : Fragment() {

    private var binding: FragmentMainScreenBinding? = null
    private val scope = CoroutineScope(Dispatchers.IO)

    private inline fun withBinding(block: FragmentMainScreenBinding.() -> Unit) {      //чтобы не проверять каждый раз на нулл
        binding?.block()
    }

    private val dataModel: viewModelMainScreen by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainScreenBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        withBinding{

            dataModel.viewStateMainScreen.observe(viewLifecycleOwner) {state ->

                Date.setTextKeepState(state.date.toString())
                Temp.setTextKeepState(state.temp.toString())
                Humidity.setTextKeepState(state.humidity.toString())
                //WindSpeed.setTextKeepState(state.windSpeed.toString())
                //PressureMM.setTextKeepState(state.pressureMM.toString())
                //weatherNow.text = state.condition
                PrecType.setTextKeepState(state.precType.toString())
            }


            scope.launch {
                while (true) {
                    dataModel.goToInetForMainScreen()
                    delay(600_000)
                }
            }

            goToDetail.setOnClickListener {
                findNavController().navigate(R.id.action_main_Screen_to_details)
                scope.cancel()
            }

            goToForecast.setOnClickListener {
                findNavController().navigate(R.id.action_main_Screen_to_forecast)
                scope.cancel()
            }

        }

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {                               //логика кнопки бэк
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > -1) {
                    childFragmentManager.popBackStack()
                }
                else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }   //не даст вернуться к экрану загрузки

}