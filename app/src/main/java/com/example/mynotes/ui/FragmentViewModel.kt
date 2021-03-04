package com.example.mynotes.ui

import android.icu.text.CaseMap
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynotes.data.models.Note
import java.util.*

class FragmentViewModel : ViewModel() {

    fun dateTime(): String {
        val date = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.ENGLISH)
            .format(Date())
        return date.toString()
    }
val emptyDatabase : MutableLiveData<Boolean> = MutableLiveData(true)
    fun checkIfDatabaseEmpty(note: Note){

    }

}