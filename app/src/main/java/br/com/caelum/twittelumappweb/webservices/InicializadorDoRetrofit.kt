package br.com.caelum.twittelumappweb.webservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorDoRetrofit {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://50255dbc.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}