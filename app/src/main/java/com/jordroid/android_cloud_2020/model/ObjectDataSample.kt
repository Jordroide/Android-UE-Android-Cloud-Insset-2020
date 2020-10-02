package com.jordroid.android_cloud_2020.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "android_version_object_table")
data class ObjectDataSample(
    val versionName: String,
    val versionCode: Int,
    val versionImage: String
) : Comparable<ObjectDataSample>, Cloneable {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    override fun compareTo(other: ObjectDataSample): Int {
        return if (other.id == this.id && other.versionName == this.versionName && other.versionCode == this.versionCode) 0 else 1
    }
}