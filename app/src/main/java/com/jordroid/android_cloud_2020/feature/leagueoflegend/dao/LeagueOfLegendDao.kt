package com.jordroid.android_cloud_2020.feature.leagueoflegend.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jordroid.android_cloud_2020.feature.leagueoflegend.model.LeagueOfLegendChampion

@Dao
interface LeagueOfLegendDao {

    @Query("SELECT * FROM league_of_legend_champion ORDER BY id ASC")
    fun selectAll(): LiveData<List<LeagueOfLegendChampion>>

    @Insert()
    fun insert(leagueOfLegendChampion: LeagueOfLegendChampion)
}