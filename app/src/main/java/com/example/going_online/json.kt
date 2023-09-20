//package com.example.going_online
//
//data class WeatherJson(
//    val fact: Fact? = null,
//    val forecasts: List<Forecast?>? = null,
//    val info: Info? = null,
//    val now: Int? = null,
//    val now_dt: String? = null
//)
//
//data class _Fact(
//    val cloudness: Int? = null,
//    val condition: String? = null,
//    val daytime: String? = null,
//    val feels_like: Int? = null,
//    val humidity: Int? = null,
//    val icon: String? = null,
//    val is_thunder: Boolean? = null,
//    val obs_time: Int? = null,
//    val phenom_condition: String? = null,
//    val phenom_icon: String? = null,
//    val polar: Boolean? = null,
//    val prec_strength: Double? = null,
//    val prec_type: Int? = null,
//    val pressure_mm: Int? = null,
//    val pressure_pa: Int? = null,
//    val season: String? = null,
//    val temp: Int? = null,
//    val wind_dir: String? = null,
//    val wind_gust: Double? = null,
//    val wind_speed: Double? = null
//)
//
//data class Forecast(
//    val date: String? = null,
//    val date_ts: Int? = null,
//    val hours: List<Hour?>? = null,
//    val moon_code: Int? = null,
//    val moon_text: String? = null,
//    val parts: Parts? = null,
//    val sunrise: String? = null,
//    val sunset: String? = null,
//    val week: Int? = null
//)
//
//data class Info(
//    val def_pressure_mm: Int? = null,
//    val def_pressure_pa: Int? = null,
//    val lat: Double? = null,
//    val lon: Double? = null,
//    val tzinfo: Tzinfo? = null,
//    val url: String? = null
//)
//
//data class Hour(
//    val cloudness: Double? = null,
//    val condition: String? = null,
//    val feels_like: Int? = null,
//    val hour: String? = null,
//    val hour_ts: Int? = null,
//    val humidity: Int? = null,
//    val icon: String? = null,
//    val is_thunder: Boolean? = null,
//    val prec_mm: Double? = null,
//    val prec_period: Int? = null,
//    val prec_strength: Double? = null,
//    val prec_type: Int? = null,
//    val pressure_mm: Int? = null,
//    val pressure_pa: Int? = null,
//    val temp: Int? = null,
//    val wind_dir: String? = null,
//    val wind_gust: Double? = null,
//    val wind_speed: Double? = null
//)
//
//data class Parts(
//    val day_short: DayShort? = null,
//    val evening: Evening? = null,
//    val night: Night? = null,
//    val night_short: NightShort? = null
//)
//
//data class DayShort(
//    val cloudness: Int? = null,
//    val condition: String? = null,
//    val feels_like: Int? = null,
//    val humidity: Int? = null,
//    val icon: String? = null,
//    val prec_strength: Double? = null,
//    val prec_type: Int? = null,
//    val pressure_mm: Int? = null,
//    val pressure_pa: Int? = null,
//    val temp: Int? = null,
//    val temp_min: Int? = null,
//    val wind_dir: String? = null,
//    val wind_gust: Double? = null,
//    val wind_speed: Double? = null
//)
//
//data class Evening(
//    val cloudness: Double? = null,
//    val condition: String? = null,
//    val daytime: String? = null,
//    val feels_like: Int? = null,
//    val humidity: Int? = null,
//    val icon: String? = null,
//    val polar: Boolean? = null,
//    val prec_mm: Double? = null,
//    val prec_period: Int? = null,
//    val prec_strength: Double? = null,
//    val prec_type: Int? = null,
//    val pressure_mm: Int? = null,
//    val pressure_pa: Int? = null,
//    val temp_avg: Int? = null,
//    val temp_max: Int? = null,
//    val temp_min: Int? = null,
//    val wind_dir: String? = null,
//    val wind_speed: Double? = null
//)
//
//data class Night(
//    val cloudness: Double? = null,
//    val condition: String? = null,
//    val daytime: String? = null,
//    val feels_like: Int? = null,
//    val humidity: Int? = null,
//    val icon: String? = null,
//    val polar: Boolean? = null,
//    val prec_mm: Int? = null,
//    val prec_period: Int? = null,
//    val prec_strength: Int? = null,
//    val prec_type: Int? = null,
//    val pressure_mm: Int? = null,
//    val pressure_pa: Int? = null,
//    val temp_avg: Int? = null,
//    val temp_max: Int? = null,
//    val temp_min: Int? = null,
//    val wind_dir: String? = null,
//    val wind_gust: Int? = null,
//    val wind_speed: Double? = null
//)
//
//data class NightShort(
//    val cloudness: Double? = null,
//    val condition: String? = null,
//    val feels_like: Int? = null,
//    val humidity: Int? = null,
//    val icon: String? = null,
//    val prec_strength: Int? = null,
//    val prec_type: Int? = null,
//    val pressure_mm: Int? = null,
//    val pressure_pa: Int? = null,
//    val temp: Int? = null,
//    val wind_dir: String? = null,
//    val wind_gust: Double? = null,
//    val wind_speed: Double? = null
//)
//
//data class Tzinfo(
//    val abbr: String? = null,
//    val dst: Boolean? = null,
//    val name: String? = null,
//    val offset: Int? = null
//)