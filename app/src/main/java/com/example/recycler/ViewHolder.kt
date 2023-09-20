package com.example.recycler


import android.annotation.SuppressLint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.WeatherPictures
import com.example.coursework.databinding.ItemRecyclerBinding
import com.example.viewState.viewStateForecast1
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class ViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {  //служит для оптимизации ресурсов и является своеобразным контейнером для всех элементов, входящих в список

    @SuppressLint("SimpleDateFormat")
    fun bind(model: viewStateForecast1){

        val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val day = LocalDate.parse(model.date , firstApiFormat)

        //val datetime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))

        val now = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ZonedDateTime.now(ZoneId.of("Europe/Moscow")))

        binding.Date.text =
            (if (day.toString() == now) "сегодня" else
                WeatherPictures.week[day.dayOfWeek.toString().lowercase()])

        binding.TempMorning.text = model.tempMorning.toString()
        binding.MorningCondition.setImageDrawable(ContextCompat.getDrawable(itemView.context, WeatherPictures.weatherPicturesMap[model.conditionMorning]!!))

        binding.TempDey.text = model.tempDay.toString()
        binding.DayCondition.setImageDrawable(ContextCompat.getDrawable(itemView.context, WeatherPictures.weatherPicturesMap[model.conditionDay]!!))

        binding.TempEvening.text = model.tempEvening.toString()
        binding.EveningCondition.setImageDrawable(ContextCompat.getDrawable(itemView.context, WeatherPictures.weatherPicturesMap[model.conditionEvening]!!))

        binding.TempNight.text = model.tempNight.toString()
        binding.NightCondition.setImageDrawable(ContextCompat.getDrawable(itemView.context, WeatherPictures.weatherPicturesMap[model.conditionNight]!!))
    }

}