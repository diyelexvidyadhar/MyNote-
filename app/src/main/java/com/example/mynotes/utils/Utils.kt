package com.example.mynotes.utils

import android.content.Context
import android.widget.Toast

fun Context.toastmsg(message : String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}