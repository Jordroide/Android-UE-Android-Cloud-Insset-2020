package com.jordroid.android_cloud_2020.feature.leagueoflegend.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "league_of_legend_champion")
data class LeagueOfLegendChampion(
        @Expose
        @SerializedName("type")
        val type: String,

        @Expose
        @SerializedName("format")
        val format: String,

        @Expose
        @SerializedName("version")
        val version: String,

        @Expose
        @SerializedName("data")
        @Embedded
        val data: LeagueOfLegendData
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
