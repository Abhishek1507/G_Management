package com.example.g_management.activities.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toastLong(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}
fun Context.toastShort(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
fun ProgressBar.show(){
    visibility = View.VISIBLE
}
fun ProgressBar.hide(){
    visibility = View.GONE
}
fun logi(tag: String,msg: String){
    Log.i(tag,msg)
}
fun loge(tag: String,msg: String){
    Log.e(tag,msg)
}