package com.jordroid.android_cloud_2020.feature.leagueoflegend.endpoint

import com.jordroid.android_cloud_2020.feature.leagueoflegend.model.LeagueOfLegendChampion
import retrofit2.http.GET
import retrofit2.http.Url

interface LeagueOfLegendEndpoint {

    @GET("Aatrox.json")
    suspend fun getAatrox(): LeagueOfLegendChampion

    @GET("Bard.json")
    suspend fun getBard(): LeagueOfLegendChampion

    @GET
    suspend fun getChampion(@Url name : String) : LeagueOfLegendChampion
}