package com.example.mynotes.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var subtitle: String,
    var description: String,
    var dateTime: String,
    var imagePath: String,
    var webUrl: String,
    var color: String
):Parcelable