package com.jordroid.android_cloud_2020.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jordroid.android_cloud_2020.dao.AndroidVersionDao
import com.jordroid.android_cloud_2020.dao.ChuckNorrisQuoteDao
import com.jordroid.android_cloud_2020.feature.leagueoflegend.dao.LeagueOfLegendDao
import com.jordroid.android_cloud_2020.feature.leagueoflegend.model.LeagueOfLegendChampion
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote
import com.jordroid.android_cloud_2020.model.ObjectDataSample

@TypeConverters(Converters::class)
@Database(
    entities = [
        ObjectDataSample::class,
        ChuckNorrisQuote::class,
        LeagueOfLegendChampion::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun mAndroidVersionDao(): AndroidVersionDao

    abstract fun mChuckNorrisDao(): ChuckNorrisQuoteDao

    abstract fun mLeagueOfLegendDao(): LeagueOfLegendDao
}
