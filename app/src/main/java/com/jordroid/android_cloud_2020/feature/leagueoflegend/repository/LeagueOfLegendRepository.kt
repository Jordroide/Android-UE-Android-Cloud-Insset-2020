package com.jordroid.android_cloud_2020.feature.leagueoflegend.repository

import com.jordroid.android_cloud_2020.architecture.CustomApplication
import com.jordroid.android_cloud_2020.architecture.RetrofitBuilder

class LeagueOfLegendRepository {

    private val mLeagueOfLegendDao = CustomApplication.instance.mApplicationDatabase.mLeagueOfLegendDao()

    suspend fun fetchData() {
        val aatrox = RetrofitBuilder.getLeagueOfLegend().getAatrox()
        val bard = RetrofitBuilder.getLeagueOfLegend().getBard()


        val test = RetrofitBuilder.getLeagueOfLegend().getChampion("Lulu.json")

        mLeagueOfLegendDao.insert(aatrox)
        mLeagueOfLegendDao.insert(bard)
        mLeagueOfLegendDao.insert(test)
    }
}