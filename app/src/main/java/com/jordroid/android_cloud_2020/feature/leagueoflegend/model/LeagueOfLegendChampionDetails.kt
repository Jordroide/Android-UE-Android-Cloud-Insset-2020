package com.jordroid.android_cloud_2020.feature.leagueoflegend.model

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LeagueOfLegendChampionDetails(
        @Expose
        @SerializedName("key")
        val key: String,

        @Expose
        @SerializedName("name")
        val name: String,

        @Expose
        @SerializedName("title")
        val title: String,

        @Expose
        @SerializedName("image")
        @Embedded
        val image: LeagueOfLegendImage,

        @Expose
        @SerializedName("lore")
        val lore: String,

        @Expose
        @SerializedName("blurb")
        val blurb: String,

        @Expose
        @SerializedName("allytips")
        val allytips: List<String>,

        @Expose
        @SerializedName("enemytips")
        val enemytips: List<String>
)