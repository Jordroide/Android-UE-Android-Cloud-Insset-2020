package com.jordroid.android_cloud_2020.feature.leagueoflegend.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LeagueOfLegendImage(
        @Expose
        @SerializedName("full")
        val full: String,

        @Expose
        @SerializedName("sprite")
        val sprite: String,

        @Expose
        @SerializedName("group")
        val group: String
)