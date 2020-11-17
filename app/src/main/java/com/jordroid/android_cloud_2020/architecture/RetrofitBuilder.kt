package com.jordroid.android_cloud_2020.architecture

import com.google.gson.GsonBuilder
import com.jordroid.android_cloud_2020.endpoint.ChuckNorrisQuoteEndpoint
import com.jordroid.android_cloud_2020.feature.leagueoflegend.endpoint.LeagueOfLegendEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        .build()

    private val retrofitLol: Retrofit = Retrofit.Builder()
        .baseUrl("https://ddragon.leagueoflegends.com/cdn/10.22.1/data/${Locale.getDefault()}/champion/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        .build()

    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint =
        retrofit.create(ChuckNorrisQuoteEndpoint::class.java)

    fun getLeagueOfLegend(): LeagueOfLegendEndpoint =
        retrofitLol.create(LeagueOfLegendEndpoint::class.java)
}