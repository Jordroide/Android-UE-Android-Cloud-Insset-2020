package com.jordroid.android_cloud_2020.feature.leagueoflegend.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LeagueOfLegendData(
        @Expose
        @SerializedName(value = "default", alternate = ["Aatrox","Bard","Lulu"])
        @Embedded
        val leagueOfLegendChampionDetails : LeagueOfLegendChampionDetails
)