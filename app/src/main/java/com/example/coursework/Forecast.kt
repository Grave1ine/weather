package com.example.coursework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursework.databinding.FragmentForecastBinding
import com.example.coursework.databinding.FragmentMainScreenBinding
import com.example.recycler.Adapter
import com.example.viewModels.viewModelForecast
import com.example.viewModels.viewModelMainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

//прогноз погоды на ближайшие 5 дней каждые 3 часа
//@AndroidEntryPoint
class Forecast : Fragment() {

    private var binding: FragmentForecastBinding? = null
    private var job: Job? = null
    private lateinit var adapter: Adapter
    //private val scope = CoroutineScope(Dispatchers.IO)

    private inline fun withBinding(block: FragmentForecastBinding.() -> Unit) {      //чтобы не проверять каждый раз на нулл
        binding?.block()
    }

    private val dataModel: viewModelForecast by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentForecastBinding.inflate(layoutInflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        withBinding{
            dataModel.viewStateForecast.observe(viewLifecycleOwner) {state ->
                adapter.setItems(state.forecast.orEmpty())
            }
            val dividerDrawable =                                                                   //разделитель
                context?.let { AppCompatResources.getDrawable(it, R.drawable.divider) }
            recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                dividerDrawable?.let { setDrawable(it) }
            })
        }

        withBinding {
            adapter = Adapter()
            val recyclerView = recyclerView
            val layoutManager = LinearLayoutManager(requireContext())

            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
        }


    }

    override fun onResume() {
        super.onResume()
        job = lifecycleScope.launch {
            while (true) {
                dataModel.goToInetForForecast()
                delay(600_000)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        job?.cancel()
    }


}