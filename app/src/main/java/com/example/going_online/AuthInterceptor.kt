package com.example.going_online

import com.example.coursework.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthInterceptor : Interceptor {                              //перехват запроса на сервер с добавлением в него ключа?
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("X-Yandex-API-Key", BuildConfig.API_KEY)      //добавит к запросу ключ
            .build()
        return chain.proceed(authenticatedRequest)
    }
}


//class AuthInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request: Request = chain.request()
//        val authenticatedRequest = request.newBuilder()
//            .url(request.url().newBuilder().addEncodedQueryParameter("X-Yandex-API-Key", BuildConfig.API_KEY).build())    //найдет в строке запроса appid и подставит ему ключ
//            .build()
//        return chain.proceed(authenticatedRequest)
//    }
//
//}

//это intercept модифицирует запрос на сервер, добавляя ключь и имя. иначе не откликнится сервввак

//- берут то, что есть в запросе (чейн.реквест). Чейн - это цепь
//- создают новый билдер запроса на основе того, что уже есть
//- добавляют заголовок
//- прокидывают модифицированный запрос дальше по цепочке вместо исходного